package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 도서리스트를 컬렉션으로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {
	private final List<Book> bookList = new ArrayList<>();

	private static final IBookManager bm = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static IBookManager getInstance() {
		return bm;
	}

	@Override
	public void add(Book book) {
		bookList.add(book);
	}

	@Override
	public void remove(String isbn) {
		for (int i = 0; i < bookList.size(); i++) {
			if(isbn.equals(bookList.get(i).getIsbn())) {
				bookList.remove(i--);
			}
		}
	}

	@Override
	public Book[] getList() {
		return bookList.toArray(new Book[0]);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for (Book b : bookList) {
			if (isbn.equals(b.getIsbn())) return b;
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		return bookList.stream()
			.filter(b -> b.getTitle().contains(title))
			.toArray(Book[]::new);
	}

	@Override
	public Magazine[] getMagazines() {
		return bookList.stream()
			.filter(b -> b instanceof Magazine)
			.map(m -> (Magazine) m)
			.toArray(Magazine[]::new);
	}

	@Override
	public Book[] getBooks() {
		return bookList.stream()
			.filter(b -> !(b instanceof Magazine))
			.toArray(Book[]::new);
	}

	@Override
	public int getTotalPrice() {
		return bookList.stream()
			.mapToInt(Book::getPrice)
			.sum();
	}

	@Override
	public double getPriceAvg() {
		if (bookList.isEmpty()) return 0;
		return (double) getTotalPrice() / bookList.size();
	}
}
