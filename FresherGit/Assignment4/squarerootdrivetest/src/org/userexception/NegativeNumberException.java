package org.userexception;

/* user defined exception if number entered is negative*/

/**
 * @author Deependra Singh
 * @purpose Create a class calc inside a package utility. This class will have a
 *          method findRoot, which will return square root of given number.
 *          Create another class User1 inside the package allusers. USer1 calls
 *          the methods findRoot
 *
 */

@SuppressWarnings("serial")
public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		System.out.println("The number you entered is negative");
	}

}
