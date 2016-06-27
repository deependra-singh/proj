/*
 * Author: Deependra Singh
 * Purpose: Assignment number 4
 * 			Create a negativeNumberException to be thrown by the method.
 * 			Find square root, If the user enters a negative number
 */
package org.assignment.four.squareroot;

import org.assignment.four.negativeexception.NegativeNumberException;

public class CalculateSquareRoot {

	// method to calculate square root
	public void calculateSquareRoot(double num) {
		if (num < 0) {
			try {
				// throw exception if number is negative
				throw new NegativeNumberException();
			} catch (NegativeNumberException e) {

			}
		} else {
			// calculate and print square root
			System.out.println(Math.sqrt(num));
		}
	}

}
