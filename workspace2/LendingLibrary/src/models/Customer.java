package models;
import java.util.Date;
import java.util.GregorianCalendar;

import utilities.GenderType;

public class Customer {

	private String title;
	private String firstName;
	private String surname;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private int customerNumber;
	private GenderType gender;
	private boolean isValid;
	private Date expiryDate;

	public Customer(String title, String firstName, String surname,
			String address, String phoneNumber, String emailAddress,
			int customerNumber, GenderType gender) {

		this.title = title;
		this.firstName = firstName;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.customerNumber = customerNumber;
		this.gender = gender;
		this.isValid = true;
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR,1);
		this.expiryDate = gCal.getTime();
		

		// setName(title,firstName,surname);
	}

	public String getFirstName() {

		return firstName;
	}

	public String getSurname() {

		return surname;
	}

	public String getTitle() {

		return title;
	}

	public String getMailingName() {

		StringBuilder sb = new StringBuilder(title);
		sb.append(" ");
		sb.append(firstName.substring(0,1));
		sb.append(" ");
		sb.append(surname);
		
		String mailingName = title + " " + firstName.charAt(0) + " " + surname;

		return mailingName;

	}

	public GenderType getGender() {
		return gender;
	}
	
	public Date getExpiryDate(){
		return expiryDate;
	}

}
