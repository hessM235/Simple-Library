package models.test;

import static org.junit.Assert.*;
import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;

import org.junit.Test;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book("1", "Intro To Java", "", "", "", 0);
		bc.addBook(book1);
	}

	@Test
	public void testAddABook() {

		int initialNumber = bc.getNumberOfBooks();
		System.out.println(initialNumber);
		Book book = new Book("2", "", "", "", "", 0);
		bc.addBook(book);

		assertTrue(initialNumber == bc.getNumberOfBooks() - 1);
	}

	@Test
	public void testFindABook() {

		try {
			Book foundBook = bc.findBook("Intro To Java");
		} catch (BookNotFoundException e) {
			fail("Book Not Found");
		}

	}

	@Test(expected = BookNotFoundException.class)
	public void testFindABookThatDoesNotExist() throws BookNotFoundException {

		Book foundBook = bc.findBook("Thinking In Java");
	}

	@Test
	public void testFindABookIgnoreCase() {

		try {
			Book foundBook = bc.findBook("Intro To Java");
		} catch (BookNotFoundException e) {
			fail("Book Not Found");
		}

	}
	
	@Test
	public void findABookWithExtraSpaces() {

		try {
			Book foundBook = bc.findBook(" Intro To Java ");
		} catch (BookNotFoundException e) {
			fail("Book Not Found");
		}

	}

}
