package models.test;

import static org.junit.Assert.*;
import models.Book;

import org.junit.Test;

public class BookTest {

	@Test
	public void testTwoEqualBooks() {
		Book book1 = new Book(1, "", "", "", "", 0);
		Book book2 = new Book(1, "", "", "", "", 0);
				
		assertTrue(book1.equals(book2));
	}
	
	@Test
	public void testTwoUnequalBooks() {
		
		Book book1 = new Book(1, "", "", "", "", 0);
		Book book2 = new Book(2, "", "", "", "", 0);
	
		assertFalse(book1.equals(book2));
		
	}

}
