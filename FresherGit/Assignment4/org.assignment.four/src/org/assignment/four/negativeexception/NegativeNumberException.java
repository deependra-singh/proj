/*
 * Author: Deependra Singh
 * Purpose: Assignment number 4
 * 			Create a negativeNumberException to be thrown by the method.
 * 			Find square root, If the user enters a negative number
 */
package org.assignment.four.negativeexception;

/* user defined exception if number entered is negative*/

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		System.out.println("The number you entered is negative");
	}

}
