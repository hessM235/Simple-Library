package models;

import java.util.HashSet;

public class CustomerRecords {
	private HashSet<Customer> customerRecord;
	
	
	public CustomerRecords() {
		
		customerRecord = new HashSet<Customer>();
	}

	public void addCustomer(Customer newCustomer) {

		customerRecord.add(newCustomer);
	}

	public Customer findByName(String customer) throws customerNotFoundException {
        
		customer = customer.trim();

		for (Customer nextCustomer : customerRecord) {
			if (nextCustomer.getMailingName().equals(customer)) {
				return nextCustomer;
			}

		}
		throw new customerNotFoundException();
	}
	
	public int getNumberOfCustomer(){
		return customerRecord.size();
	}
}
