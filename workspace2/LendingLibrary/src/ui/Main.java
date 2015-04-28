package ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import utilities.GenderType;
import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import models.Customer;
import models.DVD;
import models.Loan;
import models.LoanAlreadyExistException;
import models.LoanNotFoundException;
import models.LoanRegistry;
import models.Material;

public class Main {

	public static void main(String[] args) throws BookNotFoundException,
			LoanAlreadyExistException {

		double d = 1;

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMinimumFractionDigits(5);
		nf.setMaximumFractionDigits(5);
		// System.out.println(nf.format(d));

		BigDecimal price = new BigDecimal(0.1);
		BigDecimal addValue = new BigDecimal(0.1);
		for (int i = 0; i < 10; i++) {
			price = price.add(addValue);
			System.out.println(price);
		}

		BookCatalog bookCatalog = new BookCatalog();

		Book book1 = new Book(1, "Intro to Java", "Matt Greencroft", "12345",
				"any town", 400);
		Book book2 = new Book(2, "Better Java", "Joe LeBlanc", "23456",
				"any town", 150);
		DVD dvd1 = new DVD(3, "An Epic Film About Java", "Anytown Branch",
				"Steven Spielberg", "99887", 120);
		DVD dvd2 = new DVD(3, "An Epic Film About Java", "Anytown Branch",
				"Steven Spielberg", "99887", 120);

		System.out.println(dvd1.getTitle());
		book1.relocate("MyCity Branch");

		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);

		UI ui = new UI();
		ui.printHeader();

		ui.printBookCatalog(bookCatalog.getBook());

		try {
			Book foundBook = bookCatalog.findBook("Better Java");
			System.out.println("We found " + foundBook.getTitle());
		} catch (BookNotFoundException e) {
			System.out.println("The book wasn't found.");
		}

		Customer customer = new Customer("Mr.", "Michael", "Smith",
				"1 high street", "1234", "a@b.com", 1, GenderType.MALE);

		System.out.println(customer.getExpiryDate());
		System.out.println(customer.getMailingName());

		System.out.println(customer);
		System.out.println(dvd1);

		System.out.println(dvd1.equals(dvd1));

		Loan firstLoan = new Loan(1, customer, book1);
		System.out.println(firstLoan.getDueDate());
		System.out.println(firstLoan);

		LoanRegistry registry = new LoanRegistry();

		try {
			registry.addLoan(firstLoan);
			System.out.println("addloan worked");
		
		} catch (LoanAlreadyExistException e) {
			System.out.println("addloan failed");
		}
		
		try {
			registry.addLoan(firstLoan);
			System.out.println("addloan worked");
		
		} catch (LoanAlreadyExistException e) {
			System.out.println("addloan failed");
		}
		
		System.out.println(registry.isBookOnLoan(book1.getID()));
		firstLoan.endLoan();
		System.out.println(registry.isBookOnLoan(book1.getID()));

	}
}
