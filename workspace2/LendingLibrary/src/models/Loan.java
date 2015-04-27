package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilities.LoanStatus;

public class Loan {

	private int id;
	private String customer;
	private String book;
	private Date startDate;
	private Date dueDate;
	private Date returnDate;
	private LoanStatus status;

	public Loan(int id, String customer, String book, Date startDate,
			Date dueDate, LoanStatus status) throws ParseException {
		
		Date startDate1 = new SimpleDateFormat("MM/dd/yyyy").parse("04/27/2015");
		Date dueDate1 = new SimpleDateFormat("MM/dd/yyyy").parse("05/11/2015");
		
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.startDate = startDate1;
		this.dueDate = dueDate1;
		this.status = LoanStatus.CURRENT;
	}

	@Override
	public String toString() {
		return "Loan [customer=" + customer + ", book=" + book + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getCustomer() {
		return customer;
	}

	public String getBook() {
		return book;
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	public void endLoan() throws ParseException {
		
		Date returnDate1 = new SimpleDateFormat("MM/dd/yyyy").parse("04/27/2015");
		
		status = LoanStatus.HISTORIC;
		returnDate = returnDate1;
		
	}

}
