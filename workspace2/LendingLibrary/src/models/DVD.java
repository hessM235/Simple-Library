package models;

public class DVD extends Material {

	private String director;
	private String catalogNo;
	private int runInTime;
	private boolean licensed;

	public DVD(int id, String title, String branch, String director,
			String catalogNo, int runinTime) {
		super(id, title, branch);
		this.director = director;
		this.catalogNo = catalogNo;
		this.runInTime = runinTime;
		licensed = false;
	}

	public void license() {
		licensed = true;
	}

	public boolean lend(Customer customer) {
		if (licensed) {
			return super.lend(customer);
		} else {
			return false;
		}
	}

	public int getLoanPeriod() {
		return 7;
	}

}
