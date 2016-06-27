package org.assignment.one.bank;

public class CurrentAccount extends Account {

	// Variable initialization
	private final float rateOfInterest = 0.04f;

	// Parameterized Ctor
	public CurrentAccount(String nameOfCustomer, float balance) {
		super(nameOfCustomer, balance);
	}

	// Overridden Methods
	@Override
	public void calculateBalance() {
		float grossBalance = getBalance() + (getBalance() * rateOfInterest);
		System.out.println("Balance is=" + grossBalance);
	}

}
