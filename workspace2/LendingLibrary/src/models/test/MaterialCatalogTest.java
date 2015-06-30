package models.test;

import static org.junit.Assert.*;
import models.Book;
import models.Material;
import models.MaterialCatalogMemoryVersion;
import models.MaterialNotFoundExcepton;

import org.junit.Test;

public class MaterialCatalogTest {

	private MaterialCatalogMemoryVersion bc;
	private Book book1;

	public MaterialCatalogTest() {
		bc = new MaterialCatalogMemoryVersion();
		Book book1 = new Book("1","Intro to Java","","","",0);
		bc.addMaterial(book1);
	}

	@Test
	public void testAddABook() {

		int initialNumber = bc.getNumberOfMaterials();
		System.out.println(initialNumber);
		Book book = new Book("2","","","","",0);
		bc.addMaterial(book);

		assertTrue(initialNumber == bc.getNumberOfMaterials() -1);

	}

	@Test
	public void testFindBook() {

		try {
			Material foundMaterial = bc.findMaterial("Intro to Java");
		}
		catch (MaterialNotFoundExcepton e) 
		{
			fail("Book not found");
		}
	}

	@Test
	public void testFindBookIgnoringCase() {

		try {
			Material foundBook = bc.findMaterial("Intro to Java");
		}
		catch (MaterialNotFoundExcepton e) 
		{
			fail("Book not found");
		}
	}
	
	@Test
	public void testFindBookWithExtraSpaces() {

		try {
			Material foundBook = bc.findMaterial(" Intro to Java ");
		}
		catch (MaterialNotFoundExcepton e) 
		{
			fail("Book not found");
		}
	}

	@Test(expected = MaterialNotFoundExcepton.class)
	public void testFindBookThatDoesntExist() throws MaterialNotFoundExcepton {

		Material foundBook = bc.findMaterial("Learning More Java");

	}

}
