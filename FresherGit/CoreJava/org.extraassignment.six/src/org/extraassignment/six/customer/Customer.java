package org.extraassignment.six.customer;

import org.extraassignment.six.accountType.Account;

public class Customer {

	private String name;
	private String address;
	Account account;

	//PARAMETERIZED CONSTRUCTOR
	public Customer(String name, String address, Account account) {
		super();
		this.name = name;
		this.address = address;
		this.account = account;
	}

}
