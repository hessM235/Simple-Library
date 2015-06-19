package models.test;

import static org.junit.Assert.*;
import models.Customer;
import models.CustomerRecords;
import models.customerNotFoundException;

import org.junit.Test;

import utilities.GenderType;

public class CustomerRecordsTest {
	CustomerRecords customerRecords;

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer("Mr", "Bill", "Clinton", "101 Maple",
				"555-555-5555", "clinton@test.gov", 11, GenderType.MALE);
		CustomerRecords customerRecords = new CustomerRecords();

		int initialSize = customerRecords.getNumberOfCustomer();

		customerRecords.addCustomer(customer);

		assertTrue(initialSize == customerRecords.getNumberOfCustomer() - 1);
	}

	@Test
	public void testFindCustomer() {
		try {
			Customer foundCustomer = customerRecords.findByName("Mr M Burns");
		} catch (customerNotFoundException e) {
			fail("Customer not found");
		}
	}

	@Test
	public void testNoDuplicates() {
		Customer customer = new Customer("Mr", "Montgomery", "Burns",
				"101 Maple", "555-555-5553", "Burns@plant.com", 12,
				GenderType.MALE);

		customerRecords.addCustomer(customer);
		customerRecords.addCustomer(customer);
		customerRecords.addCustomer(customer);
		customerRecords.addCustomer(customer);
		
		assertEquals(1, customerRecords.getNumberOfCustomer());
	}

	public CustomerRecordsTest() {
		customerRecords = new CustomerRecords();
		Customer customer = new Customer("Mr", "Montgomery", "Burns",
				"101 Maple", "555-555-5553", "Burns@plant.com", 12,
				GenderType.MALE);

		customerRecords.addCustomer(customer);
	}

}
