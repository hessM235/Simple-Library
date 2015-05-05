package models.test;

import static org.junit.Assert.*;
import models.Book;
import models.BookCatalog;

import org.junit.Test;

public class BookCatalogTest {

	@Test
	public void testAddABook() {

		BookCatalog bc = new BookCatalog();
		int initialNumber = bc.getNumberOfBooks();

		Book book = new Book(1, "", "", "", "", 0);
		bc.addBook(book);
		
		assertTrue(initialNumber == bc.getNumberOfBooks() -1);
	}

}
