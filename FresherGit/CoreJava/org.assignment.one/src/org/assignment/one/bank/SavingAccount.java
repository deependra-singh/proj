package org.assignment.one.bank;

public class SavingAccount extends Account {

	// Variable initialization
	private final float rateOfInterest = 0.06f;

	// Parameterized Ctor
	public SavingAccount(String nameOfCustomer, float balance) {
		super(nameOfCustomer, balance);
	}

	// Overridden Methods
	@Override
	public void calculateBalance() {
		float grossBalance = getBalance() + (getBalance() * rateOfInterest);
		System.out.println("Balance is=" + grossBalance);
	}

}
