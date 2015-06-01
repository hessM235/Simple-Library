package models.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import models.Book;
import models.Customer;
import models.Loan;

import org.junit.Test;

import utilities.GenderType;

public class LoanTest {

	@Test
	public void testDueDate() {
		
		Book book = new Book("1","","","","",2);
		Customer customer = new Customer("","","","","","", 1,GenderType.MALE);
		
		Loan loan = new Loan(0,customer,book);
		
		GregorianCalendar gcExpected = new GregorianCalendar();
		gcExpected.add(GregorianCalendar.DAY_OF_WEEK,14);
		
		GregorianCalendar gcActual = new GregorianCalendar();
		gcActual.setTime(loan.getDueDate());
		
		assertEquals(gcExpected.get(GregorianCalendar.YEAR),gcActual.get(GregorianCalendar.YEAR));
		assertEquals(gcExpected.get(GregorianCalendar.MONTH),gcActual.get(GregorianCalendar.MONTH));
		assertEquals(gcExpected.get(GregorianCalendar.DAY_OF_MONTH),gcActual.get(GregorianCalendar.DAY_OF_MONTH));
		//fail("Not yet implemented");
	}

}
