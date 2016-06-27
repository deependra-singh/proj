/*
 * Author: Deependra Singh
 * Purpose: Assignment number 4
 * 			Create a insufficientBalanceException to be thrown by the method withdraw()
 * 			in Account class. If the amount to be withdrawn is greater than balance.
 */
package org.assignment.four.insufficientbalanceexception;

/*user defined exception class for insufficient balance in account*/

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
		System.out.println("You don't have enough balance");
	}

}
