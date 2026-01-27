package com.ssafy.ws.step3;

import java.util.Arrays;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		IBookManager bm = BookManagerImpl.getInstance();

		bm.add(new Book("978-0001", "자바의 정석", "남궁성", "도우출판", 35000, "자바 입문/실전"));
		bm.add(new Book("978-0002", "이펙티브 자바", "조슈아 블로크", "인사이트", 45000, "자바 베스트 프랙티스"));
		bm.add(new Magazine("979-1001", "월간 개발", "편집부", "테크출판", 12000, "개발 트렌드", 2026, 1));
		bm.add(new Magazine("979-1002", "월간 자바", "편집부", "테크출판", 13000, "자바 특집", 2025, 9));

		System.out.println("getList()***********************");
		System.out.println(Arrays.toString(bm.getList()));

		System.out.println("getBooks()***********************");
		System.out.println(Arrays.toString(bm.getBooks()));

		System.out.println("getMagzins()***********************");
		System.out.println(Arrays.toString(bm.getMagazines()));

		System.out.println("remove()***********************");
		bm.remove("978-0001");
		System.out.println(Arrays.toString(bm.getList()));

		System.out.println("searchByIsbn()***********************");
		System.out.println(bm.searchByIsbn("979-1001"));

		System.out.println("searchByTitle()***********************");
		System.out.println(Arrays.toString(bm.searchByTitle("자바")));

		System.out.println("totalPrice()***********************");
		System.out.println(bm.getTotalPrice());

		System.out.println("Avg()***********************");
		System.out.println(bm.getPriceAvg());
	}
}
