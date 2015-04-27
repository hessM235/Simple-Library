package models;

public class LoanRegistry {

	private Loan[] registry = new Loan[100];
	private int nextPosition = 0;

	public LoanRegistry(Loan[] registry) {
		super();
		this.registry = registry;
	}

	public void addLoan(Loan loan) throws LoanAlreadyExistException {

		registry[nextPosition] = loan;

		for (int i = 0; i < nextPosition; i++) {
			if (registry[i].equals(loan)) {
				throw new LoanAlreadyExistException();

			} else {
				nextPosition++;
			}
		}
	}
}