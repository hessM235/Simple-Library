package models;

import java.util.HashMap;

public class BookCatalog {

	private HashMap<Integer, Book> bookMap;
	
	

	// private Book[] bookArray = new Book[100];
	// private int nextPosition = 0;

	public BookCatalog() {
		bookMap = new HashMap<String, Book>();
	}

	public HashMap<String, Book> getBookMap() {
		return bookMap;
	}

	public int getNumberOfBooks() {
		return bookMap.size();
	}

	public void addBook(Book newBook) {

		bookMap.put(newBook.getID(), newBook);
	}

	public Book findBook(String title) throws BookNotFoundException {

		title = title.trim();

		for (Book nextBook : bookMap.values()) {
			if (nextBook.getTitle().equals(title)) {
				return nextBook;
			}
		}

		throw new BookNotFoundException();
	}
}
