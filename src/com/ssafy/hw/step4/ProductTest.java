package com.ssafy.hw.step4;

import java.util.Arrays;
import java.util.List;

public class ProductTest {

	public static void main(String[] args) {

		ProductManagerImpl pm = ProductManagerImpl.getInstance();

		System.out.println("===== 상품 등록 =====");
		pm.addProduct(new Product("P001", "키보드", 50000, 10, "Logi", "기계식 키보드"));
		pm.addProduct(new Product("P002", "마우스", 30000, 5, "Razer", "게이밍 마우스"));
		pm.addProduct(new Refrigerator("R001", "냉장고", 800000, 2, "Samsung", "삼성 냉장고", "양문형", 700, true, 2025));

		System.out.println(Arrays.toString(pm.getProductList()));
		System.out.println();

		System.out.println("===== 예외 확인: ProductCodeNotFoundException (searchByCode) =====");
		try {
			System.out.println(pm.searchByCode("P999"));
		} catch (ProductCodeNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 예외 확인: ProductCodeNotFoundException (removeProduct) =====");
		try {
			pm.removeProduct("P999");
			System.out.println("삭제 성공");
		} catch (ProductCodeNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 예외 확인: QuantityException (sell) =====");
		try {
			int after = pm.sell("P001", 999);
			System.out.println("판매 후 재고: " + after);
		} catch (ProductCodeNotFoundException e) {
			e.printStackTrace();
		} catch (QuantityException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 정상 판매 =====");
		try {
			int after = pm.sell("P001", 3);
			System.out.println("판매 후 재고: " + after);
			System.out.println("상품 상태: " + pm.searchByCode("P001"));
		} catch (ProductCodeNotFoundException e) {
			e.printStackTrace();
		} catch (QuantityException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 예외 확인: ReviewNotFoundException (getProductReview) =====");
		try {
			List<Review> reviews = pm.getProductReview("P002");
			System.out.println(reviews);
		} catch (ReviewNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 리뷰 추가 후 조회 =====");
		pm.addReview(new Review("P002", "kim", "좋아요"));
		pm.addReview(new Review("P002", "lee", "그립감 좋음"));
		try {
			List<Review> reviews = pm.getProductReview("P002");
			System.out.println(reviews);
		} catch (ReviewNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 예외 확인: NameNotFoundException (searchByName) =====");
		try {
			System.out.println(Arrays.toString(pm.searchByName("없는상품명")));
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("===== 총 재고 금액 =====");
		System.out.println(pm.getTotalPrice());
		System.out.println();

		System.out.println("===== 냉장고 목록 =====");
		System.out.println(Arrays.toString(pm.getRefrigerators()));
		System.out.println();

		System.out.println("===== 냉동고(true) 냉장고 목록 =====");
		System.out.println(Arrays.toString(pm.getRefrigeratorsFreezer(true)));
	}
}
