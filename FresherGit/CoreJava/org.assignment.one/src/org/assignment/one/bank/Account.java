package org.assignment.one.bank;

public class Account {

	// Variables Declaration
	@SuppressWarnings("unused")
	private String nameOfCustomer;
	private float balance;

	// Parameterized Ctor
	public Account(String nameOfCustomer, float balance) {
		super();
		this.nameOfCustomer = nameOfCustomer;
		this.balance = balance;
	}

	// Getter
	public float getBalance() {
		return balance;
	}

	// Method to be overridden by child classes
	public void calculateBalance() {

	}
}
