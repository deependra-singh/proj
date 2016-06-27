/*
 * Author: Deependra Singh
 * Purpose: Assignment number 4
 * 			Create a insufficientBalanceException to be thrown by the method withdraw()
 * 			in Account class. If the amount to be withdrawn is greater than balance.
 */
package org.assignment.four.tester;

import java.util.Scanner;

import org.assignment.four.account.Account;

public class AccountTester {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// input balance
		float bal = sc.nextFloat();

		// create an account object
		Account acc = new Account(bal);

		// input withdrawal amount
		float withdrawlAmount = sc.nextFloat();

		// withdraw() method is called
		acc.withdraw(withdrawlAmount);

	}

}
