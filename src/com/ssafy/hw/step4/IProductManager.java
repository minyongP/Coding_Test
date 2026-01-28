package com.ssafy.hw.step4;

import java.util.ArrayList;
import java.util.List;

/**
 * 상품리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 *
 */
public interface IProductManager {
	boolean addProduct(Product product);

	boolean updateProduct(Product product);

	boolean removeProduct(String pCode) throws ProductCodeNotFoundException;

	int sell(String pCode, int cnt) throws ProductCodeNotFoundException, QuantityException;

	Product[] getProductList();

	Product searchByCode(String pCode) throws ProductCodeNotFoundException;

	boolean addReview(Review review);

	boolean removeReview(Review review) throws ReviewNotFoundException;

	List<Review> getProductReview(String pCode) throws ReviewNotFoundException;

	Product[] searchByName(String name) throws NameNotFoundException;

	long getTotalPrice();

	Product[] getProducts();

	Refrigerator[] getRefrigerators();

	Refrigerator[] getRefrigeratorsFreezer(boolean freeze);

}
