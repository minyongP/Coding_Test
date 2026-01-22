package com.ssafy.hw.step4;

import java.util.Arrays;

public class ProductTest {
	public static void main(String[] args) {

		ProductManager pm = new ProductManager();

		// 1) 상품 등록
		System.out.println("===== 상품 등록 =====");
		pm.addProduct(new Product("P001", "키보드", 50000, 10, "Logi", "기계식 키보드"));
		pm.addProduct(new Product("P002", "마우스", 30000, 5, "Razer", "게이밍 마우스"));
		pm.addProduct(new Product("P003", "모니터", 200000, 3, "Samsung", "27인치 모니터"));
		System.out.println(Arrays.toString(pm.getProductList()));

		// 2) 상품 조회 (상품코드로 조회)
		System.out.println("\n===== 상품 코드 조회 =====");
		System.out.println(pm.searchByCode("P002"));

		// 3) 상품 수정
		System.out.println("\n===== 상품 수정 =====");
		pm.updateProduct(new Product("P002", "마우스", 25000, 7, "Razer", "할인 + 재입고"));
		System.out.println(pm.searchByCode("P002"));

		// 4) 상품 판매
		System.out.println("\n===== 상품 판매 =====");
		int remain = pm.sell("P001", 2);
		System.out.println("P001 판매 후 남은 수량: " + remain);

		// 5) 리뷰 등록
		System.out.println("\n===== 리뷰 등록 =====");
		pm.addReview(new Review(1, "P001", "minyong", "키감이 좋아요."));
		pm.addReview(new Review(2, "P001", "ssafy", "배송이 빠르고 만족합니다."));
		pm.addReview(new Review(3, "P002", "tester", "그립감이 좋아요."));

		// 6) 특정 상품 리뷰 조회
		System.out.println("\n===== P001 리뷰 목록 =====");
		System.out.println(Arrays.toString(pm.getProductReview("P001")));

		// 7) 리뷰 삭제
		System.out.println("\n===== 리뷰 삭제 (reviewId = 2) =====");
		pm.removeReview(2);
		System.out.println(Arrays.toString(pm.getProductReview("P001")));

		// 8) 상품 삭제
		System.out.println("\n===== 상품 삭제 (P003) =====");
		pm.removeProduct("P003");
		System.out.println(Arrays.toString(pm.getProductList()));
	}
}
