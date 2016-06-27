/*
 * Author: Deependra Singh
 * Purpose: Assignment number 4
 * 			Create a negativeNumberException to be thrown by the method.
 * 			Find square root, If the user enters a negative number
 */
package org.assignment.four.tester;

import java.util.Scanner;

import org.assignment.four.squareroot.CalculateSquareRoot;

public class SquareRootTester {
	public static void main(String[] args) {
		// enter number
		System.out.println("Enter number whose square root has to be found:");
		Scanner sc = new Scanner(System.in);
		double number = sc.nextDouble();

		CalculateSquareRoot sq = new CalculateSquareRoot();

		// call method for calculating square root
		sq.calculateSquareRoot(number);
	}

}
