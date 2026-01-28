	package com.ssafy.hw.step4;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	/**
	 * 상품리스트를 배열로 유지하며 관리하는 클래스
	 */
	public class ProductManagerImpl implements IProductManager {
		private static final int MAX_PRODUCT_SIZE = 100;
		private static final int MAX_REVIEW_SIZE = 1000;

		private List<Product> productList = new ArrayList<>();
		private Map<String, List<Review>> reviewMap = new HashMap<>();

		private int reviewNo = 1;

		private static final ProductManagerImpl pm = new ProductManagerImpl();

		private ProductManagerImpl() {
		}

		public static ProductManagerImpl getInstance() {
			return pm;
		}

		@Override
		public boolean addProduct(Product product) {
			if (productList.size() < MAX_PRODUCT_SIZE) {
				productList.add(product);
				return true;
			}
			return false;
		}

		@Override
		public boolean updateProduct(Product product) {
			for (int i = 0; i < productList.size(); i++) {
				if (product.getpCode().equals(productList.get(i).getpCode())) {
					productList.set(i, product);
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean removeProduct(String pCode) throws ProductCodeNotFoundException {
			for (int i = 0; i < productList.size(); i++) {
				if (pCode.equals(productList.get(i).getpCode())) {
					productList.remove(i);
					return true;
				}
			}
			throw new ProductCodeNotFoundException(pCode);
		}

		@Override
		public int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException{
			for (Product p : productList) {
				if (pCode.equals(p.getpCode())) {
					int curQuantity = p.getQuantity();
					int afterQuantity = curQuantity - cnt;
					if (afterQuantity < 0) throw new QuantityException();
					p.setQuantity(afterQuantity);
					return afterQuantity;
				}
			}
			throw new ProductCodeNotFoundException(pCode);
		}

		@Override
		public Product[] getProducts() {
			return productList.toArray(new Product[0]);
		}

		@Override
		public Product searchByCode(String pCode) throws ProductCodeNotFoundException{
			for (Product p : productList) {
				if (pCode.equals(p.getpCode())) {
					return p;
				}
			}
			throw new ProductCodeNotFoundException(pCode);
		}

		@Override
		public boolean addReview(Review review) {
			int totalReviews = 0;
			for (List<Review> reviews : reviewMap.values()) {
				totalReviews += reviews.size();
			}
			if (totalReviews >= MAX_REVIEW_SIZE) return false;

			review.setReviewId(reviewNo++);
			reviewMap.computeIfAbsent(review.getpCode(), k -> new ArrayList<>())
				.add(review);

			return true;
		}

		@Override
		public boolean removeReview(Review review) throws ReviewNotFoundException {
			for (Map.Entry<String, List<Review>> entry : reviewMap.entrySet()) {
				List<Review> list = entry.getValue();

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getpCode().equals(review.getpCode())) {
						list.remove(i);
						return true;
					}
				}
			}
			throw new ReviewNotFoundException(review.getpCode());
		}

		@Override
		public List<Review> getProductReview(String pCode) throws ReviewNotFoundException {
			List<Review> res = reviewMap.getOrDefault(pCode, new ArrayList<>());
			if (res.isEmpty()) throw new ReviewNotFoundException(pCode);
			return res;
		}

		@Override
		public Product[] searchByName(String name) throws NameNotFoundException{
			List<Product> list = new ArrayList<>();
			for (Product p : productList) {
				if (p.getpName().contains(name)) {
					list.add(p);
				}
			}
			if (list.isEmpty()) throw new NameNotFoundException(name);
			return list.toArray(new Product[0]);
		}

		@Override
		public long getTotalPrice() {
			long total = 0;
			for (Product p : productList) {
				total += (long) p.getPrice() * p.getQuantity();
			}
			return total;
		}

		@Override
		public Product[] getProductList() {
			return productList.toArray(new Product[0]);
		}

		@Override
		public Refrigerator[] getRefrigerators() {
			return productList.stream()
				.filter(p -> p instanceof Refrigerator)
				.map(p -> (Refrigerator) p)
				.toArray(Refrigerator[]::new);
		}

		@Override
		public Refrigerator[] getRefrigeratorsFreezer(boolean freeze) {
			return productList.stream()
				.filter(p -> p instanceof Refrigerator)
				.map(p -> (Refrigerator) p)
				.filter(r -> r.isFreezer() == freeze)
				.toArray(Refrigerator[]::new);
		}
	}
