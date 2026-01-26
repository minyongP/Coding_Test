package com.ssafy.hw.step4;

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

		printTitle("냉장고목록");
		Refrigerator[] refs = pm.getRefrigerators();
		if (refs != null) {
			for (Refrigerator r : refs) {
				System.out.println(r);
			}
		}
		System.out.println();

		printTitle("냉동고 있는 냉장고");
		Refrigerator[] freezerRefs = pm.getRefrigeratorsFreezer(true);
		if (freezerRefs != null) {
			for (Refrigerator r : freezerRefs) {
				System.out.println(r);
			}
		}
		System.out.println();

		printTitle("상품 목록");
		System.out.println(pm.searchByCode("R00001"));
		System.out.println(pm.searchByCode("P00001"));
		System.out.println();

		pm.sell("R00003", 78);

		printTitle("재고 총가격");
		System.out.println(pm.getTotalPrice() + "원");
	}

	private static void printTitle(String title) {
		System.out.println("***************************" + title + "*****************************");
	}
}
