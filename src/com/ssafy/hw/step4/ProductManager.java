package com.ssafy.hw.step4;

import java.util.Arrays;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManager {
	//코드를 작성하세요.
	private int MAX_PRODUCT_SIZE = 100;
	private int MAX_REVIEW_SIZE = 1000;

	private Product[] products = new Product[MAX_PRODUCT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int pCount = 0;
	private int rCount = 0;

	public boolean addProduct(Product product) {
		if (pCount < MAX_PRODUCT_SIZE) {
			products[pCount++] = product;
			return true;
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		for (int i = 0; i < pCount; i++) {
			if (product.getpCode().equals(products[i].getpCode())) {
				products[i] = product;
				return true;
			}
		}
		return false;
	}

	public boolean removeProduct(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (pCode.equals(products[i].getpCode())) {
				for (int j = i; j < pCount - 1; j++) {
					products[j] = products[j+1];
				}
				products[pCount - 1] = null;
				pCount--;
				return true;
			}
		}
		return false;
	}

	public int sell(String pCode, int cnt) {
		for (int i = 0; i < pCount; i++) {
			if (pCode.equals(products[i].getpCode())) {
				int curQuantity = products[i].getQuantity();
				if (cnt > curQuantity) return 0;
				products[i].setQuantity(products[i].getQuantity() - cnt);
				return curQuantity - cnt;
			}
		}
		return 0;
	}

	public Product[] getProductList() {
		return Arrays.copyOf(products, pCount);
	}

	public Product searchByCode(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (pCode.equals(products[i].getpCode())) {
				return products[i];
			}
		}
		return null;
	}

	public boolean addReview(Review review) {
		if (rCount < MAX_REVIEW_SIZE) {
			reviews[rCount++] = review;
			return true;
		}
		return false;
	}

	public boolean removeReview(int reviewId) {
		for (int i = 0; i < rCount; i++) {
			if (reviewId == reviews[i].getReviewId()) {
				for (int j = i; j < rCount - 1; j++) {
					reviews[j] = reviews[j+1];
				}
				reviews[rCount - 1] = null;
				rCount--;
				return true;
			}
		}
		return false;
	}

	public Review[] getProductReview(String pCode) {
		int cnt = 0;
		for (int i = 0; i < rCount; i++) {
			if (pCode.equals(reviews[i].getpCode())) {
				cnt++;
			}
		}
		Review[] reviewList = new Review[cnt];
		cnt = 0;
		for (int i = 0; i < rCount; i++) {
			if (pCode.equals(reviews[i].getpCode())) {
				reviewList[cnt++] = reviews[i];
			}
		}
		return reviewList;
	}

	public Product[] searchByName(String name) {
		int cnt = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpName().contains(name)) cnt++;
		}

		Product[] productList = new Product[cnt];
		cnt = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpName().contains(name))  productList[cnt++] = products[i];
		}
		return productList;
	}

	public long getTotalPrice() {
		long total = 0;
		for (int i = 0; i < pCount; i++) {
			total += (long) products[i].getPrice() * products[i].getQuantity();
		}
		return total;
	}

	public Product[] getProducts() {
		return Arrays.stream(products, 0, pCount).filter(p -> !(p instanceof Refrigerator)).toArray(Product[]::new);
	}

	public Refrigerator[] getRefrigerators() {
		int cnt = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) cnt++;
		}
		Refrigerator[] refrigerators = new Refrigerator[cnt];
		cnt = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) refrigerators[cnt++] = (Refrigerator)products[i];
		}
		return refrigerators;
	}

	public Refrigerator[] getRefrigeratorsFreezer(boolean freeze) {
		int cnt = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) cnt++;
		}
		Refrigerator[] refrigerators = new Refrigerator[cnt];
		cnt = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) refrigerators[cnt++] = (Refrigerator)products[i];
		}
		return Arrays.stream(refrigerators).filter(r -> r.isFreezer() == freeze).toArray(Refrigerator[]::new);
	}
}
