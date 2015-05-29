package models;

import utilities.LoanStatus;

public class LoanRegistry {

	private Loan[] registry;
	private int nextPosition;

	public LoanRegistry() {

		registry = new Loan[100];
		nextPosition = 0;
	}

	public void addLoan(Loan loan) throws LoanAlreadyExistException {

		for (int i = 0; i < nextPosition; i++) {
			if (registry[i].equals(loan)) {
				throw new LoanAlreadyExistException();
			}
		}
		registry[nextPosition] = loan;
		nextPosition++;

	}

	public Loan findLoan(String bookId) throws LoanNotFoundException {

		for (int i = 0; i < nextPosition; i++) {
			if (registry[i].getBook().getID() == bookId
					&& registry[i].getStatus().equals(LoanStatus.CURRENT)) {
				return registry[i];
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