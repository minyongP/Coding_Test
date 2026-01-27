package com.ssafy.hw.step4;

import java.util.List;

public class ProductTest {

	public static void main(String[] args) {

		ProductManagerImpl pm = ProductManagerImpl.getInstance();

		pm.addProduct(new Refrigerator(
			"R00001", "S냉장고", 1000000, 20, "삼성", "삼성에서 출시한 스마트냉장고입니다.",
			"냉장고", 1000, true, 2021
		));

		pm.addProduct(new Refrigerator(
			"R00002", "L냉장고", 1000000, 10, "엘지", "엘지에서 개발한 L냉장고입니다.",
			"냉장고", 300, false, 2022
		));

		pm.addProduct(new Refrigerator(
			"R00003", "T냉장고", 3000000, 200, "로보", "로보에서 출시한 AI냉장고입니다.",
			"냉장고", 1200, true, 2022
		));

		pm.addProduct(new Refrigerator(
			"R00004", "K냉장고", 5000000, 50, "코라", "코라에서 출시한 AI냉장고입니다.",
			"냉장고", 700, false, 2021
		));

		pm.addProduct(new Refrigerator(
			"R00005", "A냉장고", 1000000, 10, "에이스", "에이스에서 출시한 스마트냉장고입니다.",
			"냉장고", 800, true, 2022
		));

		pm.addProduct(new Product(
			"P00001", "우주돔", 500000, 100, "삼성", "삼성에서 출시한 우주돔입니다."
		));

		printTitle("addProduct 결과 + getProducts");
		System.out.println("getProducts length = " + pm.getProducts().length);
		printArray(pm.getProducts());
		System.out.println();

		printTitle("searchByCode");
		System.out.println(pm.searchByCode("R00001"));
		System.out.println(pm.searchByCode("P00001"));
		System.out.println(pm.searchByCode("NOT_EXIST"));
		System.out.println();

		printTitle("searchByName");
		printArray(pm.searchByName("냉장고"));
		printArray(pm.searchByName("우주"));
		printArray(pm.searchByName("없는이름"));
		System.out.println();

		printTitle("updateProduct");
		boolean upd1 = pm.updateProduct(new Product("P00001", "우주돔(수정)", 600000, 90, "삼성", "설명 수정"));
		boolean upd2 = pm.updateProduct(new Product("P99999", "없는상품", 1, 1, "X", "X"));
		System.out.println("update P00001 = " + upd1);
		System.out.println("update P99999 = " + upd2);
		System.out.println(pm.searchByCode("P00001"));
		System.out.println();

		printTitle("sell 정상/실패");
		int after1 = pm.sell("R00003", 78);
		int after2 = pm.sell("R00003", 100000);
		int after3 = pm.sell("NOT_EXIST", 1);
		System.out.println("sell R00003 78 -> after = " + after1);
		System.out.println("sell R00003 100000 -> after = " + after2);
		System.out.println("sell NOT_EXIST 1 -> after = " + after3);
		System.out.println(pm.searchByCode("R00003"));
		System.out.println();

		printTitle("getTotalPrice");
		System.out.println(pm.getTotalPrice() + "원");
		System.out.println();

		printTitle("getProductList");
		System.out.println("getProductList length = " + pm.getProductList().length);
		printArray(pm.getProductList());
		System.out.println();

		printTitle("getRefrigerators");
		Refrigerator[] refs = pm.getRefrigerators();
		System.out.println("getRefrigerators length = " + refs.length);
		printArray(refs);
		System.out.println();

		printTitle("getRefrigeratorsFreezer(true)");
		Refrigerator[] freezerTrue = pm.getRefrigeratorsFreezer(true);
		System.out.println("freezer(true) length = " + freezerTrue.length);
		printArray(freezerTrue);
		System.out.println();

		printTitle("getRefrigeratorsFreezer(false)");
		Refrigerator[] freezerFalse = pm.getRefrigeratorsFreezer(false);
		System.out.println("freezer(false) length = " + freezerFalse.length);
		printArray(freezerFalse);
		System.out.println();

		printTitle("addReview (ID는 매니저 발급)");
		Review rv1 = new Review("R00001", "minyong", "좋아요");
		Review rv2 = new Review("R00001", "jisu", "괜찮아요");
		Review rv3 = new Review("P00001", "hana", "멋져요");

		System.out.println("addReview rv1 = " + pm.addReview(rv1));
		System.out.println("addReview rv2 = " + pm.addReview(rv2));
		System.out.println("addReview rv3 = " + pm.addReview(rv3));
		System.out.println("rv1 id = " + rv1.getReviewId());
		System.out.println("rv2 id = " + rv2.getReviewId());
		System.out.println("rv3 id = " + rv3.getReviewId());
		System.out.println();

		printTitle("getProductReview");
		List<Review> rList1 = pm.getProductReview("R00001");
		List<Review> rList2 = pm.getProductReview("P00001");
		List<Review> rList3 = pm.getProductReview("NOT_EXIST");
		System.out.println("R00001 reviews size = " + rList1.size());
		printList(rList1);
		System.out.println("P00001 reviews size = " + rList2.size());
		printList(rList2);
		System.out.println("NOT_EXIST reviews size = " + rList3.size());
		printList(rList3);
		System.out.println();

		printTitle("removeReview");
		int deleteId = rv2.getReviewId();
		System.out.println("removeReview(" + deleteId + ") = " + pm.removeReview(deleteId));
		System.out.println("removeReview(999999) = " + pm.removeReview(999999));
		printTitle("R00001 reviews after delete");
		printList(pm.getProductReview("R00001"));
		System.out.println();

		printTitle("removeProduct");
		System.out.println("remove R00005 = " + pm.removeProduct("R00005"));
		System.out.println("remove R99999 = " + pm.removeProduct("R99999"));
		System.out.println(pm.searchByCode("R00005"));
		System.out.println();

		printTitle("최종 getProducts");
		printArray(pm.getProducts());
		System.out.println();

		printTitle("최종 getTotalPrice");
		System.out.println(pm.getTotalPrice() + "원");
		System.out.println();
	}

	private static void printTitle(String title) {
		System.out.println("***************************" + title + "*****************************");
	}

	private static <T> void printArray(T[] arr) {
		if (arr == null) {
			System.out.println("null");
			return;
		}
		if (arr.length == 0) {
			System.out.println("[]");
			return;
		}
		for (T t : arr) {
			System.out.println(t);
		}
	}

	private static <T> void printList(List<T> list) {
		if (list == null) {
			System.out.println("null");
			return;
		}
		if (list.isEmpty()) {
			System.out.println("[]");
			return;
		}
		for (T t : list) {
			System.out.println(t);
		}
	}
}
