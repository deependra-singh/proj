package org.assignment.one.util;

import java.util.Scanner;

import org.assignment.one.bank.Account;
import org.assignment.one.bank.CurrentAccount;
import org.assignment.one.bank.SavingAccount;

public class AccountTester {

	public void testAccount() {

		// Variable initialization
		int flag = 1;

		// Object declaration and initialization
		Account account;
		Scanner scanner = new Scanner(System.in);

		// Loop for correct execution
		while (flag != 0) {
			System.out.println("Enter type of account (Savings/Current):");
			String type = scanner.next();

			//Condition to check account type input
			if ((type.equalsIgnoreCase("savings"))
					|| type.equalsIgnoreCase("current")) {
				System.out.println("Enter name:");
				String name = scanner.next();

				System.out.println("Enter Balance:");
				float bal = scanner.nextFloat();

				//Passing values to appropriate class
				if (type.equalsIgnoreCase("savings")) {
					account = new SavingAccount(name, bal);
					account.calculateBalance();
				} else {
					account = new CurrentAccount(name, bal);
					account.calculateBalance();
				}

				flag = 0;
			} else {
				System.out.println("Please enter correct account type\n");
				flag = 1;
			}
		}

		scanner.close();

	}

}
