package com.ssafy.hw.step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManagerImpl implements IProductManager{
	private static final int MAX_PRODUCT_SIZE = 100;
	private static final int MAX_REVIEW_SIZE = 1000;

	private List<Product> productList = new ArrayList<>();
	private Map<String, List<Review>> reviewMap = new HashMap<>();

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
	public boolean removeProduct(String pCode) {
		for (int i = 0; i < productList.size(); i++) {
			if (pCode.equals(productList.get(i).getpCode())) {
				productList.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int sell(String pCode, int cnt) {
		for (Product p : productList) {
			if (pCode.equals(p.getpCode())) {
				int curQuantity = p.getQuantity();
				int afterQuantity = curQuantity - cnt;
				if (afterQuantity < 0) return 0;
				p.setQuantity(afterQuantity);
				return afterQuantity;
			}
		}
		return 0;
	}

	@Override
	public Product[] getProducts() {
		return (Product[])productList.toArray();
	}

	@Override
	public Product searchByCode(String pCode) {
		for (Product p : productList) {
			if (pCode.equals(p.getpCode())) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean addReview(Review review) {
		List<Review> list = reviewMap.get(review.getpCode());
		list.add(review);
		if (reviewMap.size() < MAX_REVIEW_SIZE) {
			reviewMap.put(review.getpCode(), list);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeReview(int reviewId) {
		for (Map.Entry<String, List<Review>> entry : reviewMap.entrySet()) {
			List<Review> list = entry.getValue();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getReviewId() == reviewId) {
					list.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Review> getProductReview(String pCode) {
		return  reviewMap.get(pCode);
	}


	@Override
	public Product[] searchByName(String name) {
		ArrayList<Product> list = new ArrayList<>();
		for (Product p : productList) {
			if (p.getpName().contains(name)) {
				list.add(p);
			}
		}
		return (Product[])list.toArray();
	}

	@Override
	public long getTotalPrice() {
		long total = 0;
		// for (int i = 0; i < pCount; i++) {
		// 	total += (long) productList[i].getPrice() * productList[i].getQuantity();
		// }
		for (Product p : productList) {
			total += p.getPrice() * p.getQuantity();
		}
		return total;
	}

	@Override
	public Product[] getProductList() {
		return (Product[])productList.toArray();
	}

	@Override
	public Refrigerator[] getRefrigerators() {
		return (Refrigerator[]) productList.stream().filter(p -> p instanceof Refrigerator).toArray();
	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freeze) {
		return (Refrigerator[]) productList.stream().filter(p -> p instanceof Refrigerator).filter(r -> ((Refrigerator)r).isFreezer()).toArray();
	}
}
