package org.assignment.one.test;

import java.util.Scanner;

import org.assignment.one.util.AccountTester;
import org.assignment.one.util.EmployeeTester;

public class AssignmentOneTest {

	public static void main(String[] args) {

		int assignmentChoice;
		String continueChoice;
		int flag = 1;

		Scanner scanner = new Scanner(System.in);

		while (flag != 0) {
			System.out
					.println("Please enter assigment number you would like to operate upon");
			assignmentChoice = scanner.nextInt();

			switch (assignmentChoice) {
			case 1:
				EmployeeTester employeetester = new EmployeeTester();
				employeetester.testEmployee();
				
				scanner.nextLine();
				
				System.out.println("Do you want to continue?");
				continueChoice = scanner.nextLine();
				if (continueChoice.toLowerCase() == "y") {
					flag = 1;
				} else {
					flag = 0;
				}
				break;

			case 2:
				AccountTester accounttester = new AccountTester();
				accounttester.testAccount();
				System.out.println("Do you want to continue?");
				continueChoice = scanner.next();
				if (continueChoice.toLowerCase() == "y") {
					flag = 1;
				} else {
					flag = 0;
				}
				break;

			default:
				System.out.println("Please enter correct choice:");
				flag = 1;
				break;
			}
		}
		scanner.close();
	}

}
