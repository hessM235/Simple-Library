package models;

import java.util.ArrayList;

import utilities.LoanStatus;

public class LoanRegistry {

	private ArrayList<Loan> registry;
	

	public LoanRegistry() {

		registry = new ArrayList<Loan>();
		
	}

	public void addLoan(Loan loan) throws LoanAlreadyExistException {

		if(registry.contains(loan)){
			throw new LoanAlreadyExistException();
		}
		
		registry.add(loan);
		

	}

	public Loan findLoan(String bookId) throws LoanNotFoundException {
		for(Loan loan : registry){
		
			if (loan.getBook().getID().equals(bookId)
					&& loan.getStatus() == LoanStatus.CURRENT) {

				return loan;
			}
		}
		throw new LoanNotFoundException();

	}

	public boolean isBookOnLoan(String bookId) {

		try {
			Loan foundLoan = findLoan(bookId);
			return true;
		} catch (LoanNotFoundException e) {
			return false;
		}

	}
}