package org.extraassignment.three.utility;

import java.util.Scanner;

import org.extraassignment.three.bank.BankApplication;
import org.extraassignment.three.bank.Customer;

public class Utility {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name;
		int accNo;
		String address;
		double accBal;
		int ch;
		char choice = 'y';

		Customer cust;
		BankApplication bank = new BankApplication();

		System.out.println("To exit press 'n'");
		
		//TO CONTINUOUSLY RUN THE LOOP
		do {
			
			System.out
					.println("Enter your choice- \n 1. Add customer \n 2. Remove customer \n "
							+ "3. Update customer details \n 4. Show customer details ");
			ch = sc.nextInt();
			
			//ACCEPTING THE CHOICE AND PROCEEDING ACCORDINGLY
			switch (ch) {
			case 1:
				System.out.println("Enter name");
				name = sc.next();

				System.out.println("Enter address");
				address = sc.next();

				System.out.println("Enter account balance");
				accBal = sc.nextDouble();

				cust = new Customer(name, address, accBal);

				System.out.println("Account created with account number: " + bank.addCustomer(cust));
				break;

			case 2:

				System.out.println("Enter account number to remove");
				accNo = sc.nextInt();
				bank.validateAccount(accNo);
				System.out.println("Customer with details --> "
						+ bank.deleteCustomer(accNo) + " removed");
				break;

			case 3:
				System.out.println("Enter account number to update");
				accNo = sc.nextInt();
				bank.validateAccount(accNo);
				System.out.println("Enter new address");
				address = sc.next();
				System.out.println("Customer details  updated "
						+ bank.updateCustomer(accNo,address));
				break;

			case 4:
				System.out.println("Enter account number to get customer details");
				accNo = sc.nextInt();
				System.out.println("Customer details are --> "
						+ bank.getCustomerInfo(accNo));
				break;

			default:
				System.out.println("Please enter a correct choice");
			}
		} while (choice != 'n');
	}
}
