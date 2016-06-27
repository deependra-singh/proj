package org.extraassignment.six.utility;

import java.util.Scanner;

import org.extraassignment.six.accountType.Account;
import org.extraassignment.six.accountType.CurrentAccount;
import org.extraassignment.six.accountType.FixedDepositAccount;
import org.extraassignment.six.customer.Customer;

public class Utility {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name;
		String address;
		int accNo;
		double accBal;
		int ch;
		Customer customer;
		Account account;

		//ACCEPTING THE INPUTS FROM USER
		System.out.println("Enter name");
		name = sc.next();

		System.out.println("Enter address");
		address = sc.next();

		System.out.println("Enter account balance");
		accBal = sc.nextDouble();

		System.out.println("Enter account no");
		accNo = sc.nextInt();

		System.out
				.println("Enter your choice- \n 1. Fixed deposit account \n 2. Current account \n");
		ch = sc.nextInt();

		// ACCEPTING CHOICE OF ACCOUNT AND DISPLAYING INTEREST ACCORDINGLY
		switch (ch) {
		case 1:
			account = new FixedDepositAccount();
			customer = new Customer(name, address, new FixedDepositAccount());
			System.out.println("total interest is "
					+ account.callInterest(accBal));
			break;

		case 2:

			account = new CurrentAccount();
			customer = new Customer(name, address, new CurrentAccount());
			System.out.println("total interest is "
					+ account.callInterest(accBal));

			break;
		default:
			System.out.println("Please enter a correct choice");
		}

	}
}
