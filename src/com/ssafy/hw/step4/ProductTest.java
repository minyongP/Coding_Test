package com.ssafy.hw.step4;

import java.util.Arrays;
import java.util.List;

public class ProductTest {

	public static void main(String[] args) {

		ProductManagerImpl pm = ProductManagerImpl.getInstance();

		System.out.println("===== 냉장고 로드 확인 =====");
		for (Product p : pm.getProductList()) {
			System.out.println(p);
		}

/*		Review r = new Review();
		r.setpCode("R00001");
		r.setWriter("park");
		r.setContent("만족합니다");
		pm.addReview(r);

		pm.saveData();*/

		try {
			for (Review rv : pm.getProductReview("R00001")) {
				System.out.println(rv);
			}
		} catch (ReviewNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
