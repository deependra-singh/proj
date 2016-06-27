package org.squareroot;

import org.userexception.NegativeNumberException;

/**
 * @author Deependra Singh
 * @purpose Create a class calc inside a package utility. This class will have a
 *          method findRoot, which will return square root of given number.
 *          Create another class User1 inside the package allusers. USer1 calls
 *          the methods findRoot
 *
 */

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
