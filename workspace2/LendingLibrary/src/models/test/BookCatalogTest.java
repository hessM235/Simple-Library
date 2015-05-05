package models.test;

import static org.junit.Assert.*;
import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;

import org.junit.Test;

public class BookCatalogTest {

	@Test
	public void testAddABook() {

		BookCatalog bc = new BookCatalog();
		int initialNumber = bc.getNumberOfBooks();

		Book book = new Book(1, "", "", "", "", 0);
		bc.addBook(book);

		assertTrue(initialNumber == bc.getNumberOfBooks() - 1);
	}

	@Test
	public void testFindABook() {

		BookCatalog bc = new BookCatalog();
		int initialNumber = bc.getNumberOfBooks();

		Book book = new Book(1, "Intro To Java", "", "", "", 0);
		bc.addBook(book);

		try {
			Book foundBook = bc.findBook("Intro To Java");
		} catch (BookNotFoundException e) {
			fail("Book Not Found");
		}
		assertTrue(initialNumber == bc.getNumberOfBooks() - 1);
	}

	@Test(expected = BookNotFoundException.class)
	public void testFindABookThatDoesNotExist() throws BookNotFoundException {

		BookCatalog bc = new BookCatalog();
		
		Book book = new Book(1, "Intro To Java", "", "", "", 0);
		bc.addBook(book);

		Book foundBook = bc.findBook("Thinking In Java");
	}

}
