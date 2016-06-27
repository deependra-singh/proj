/*
 * Author: Deependra Singh
 * Purpose: Assignment number 4
 * 			Create a insufficientBalanceException to be thrown by the method withdraw()
 * 			in Account class. If the amount to be withdrawn is greater than balance.
 */
package org.assignment.four.account;

import org.assignment.four.insufficientbalanceexception.InsufficientBalanceException;

public class Account {

	private float balance;

	// constructor
	public Account(float balance) {
		super();
		this.balance = balance;
	}

	// withdraw method
	public void withdraw(float number) {

		try {
			// check whether withdrawal amount is greater than balance
			if (balance < number) {
				// if yes throw exception
				throw new InsufficientBalanceException();
			} else {
				// withdraw the amount
				balance = balance - number;
				System.out.println("current balance" + balance);
			}
		} catch (InsufficientBalanceException e) {

		}
	}

}
