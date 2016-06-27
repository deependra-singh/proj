package org.allusers;

import java.util.Scanner;
import org.utility.Calc;

/**
 * @author Deependra Singh
 * @purpose Create a class calc inside a package utility. This class will have a
 *          method findRoot, which will return square root of given number.
 *          Create another class User1 inside the package allusers. USer1 calls
 *          the methods findRoot
 *
 */

public class User1 {

	public static void main(String[] args) {

		double number;

		Scanner scanner = new Scanner(System.in);
		System.out
				.println("Enter the number of which you want to find the square root");
		number = scanner.nextDouble();

		// Creating Instance of the Calc class from the JAR file and calling the
		// method responsible to calculate square root
		Calc calc = new Calc();
		calc.findRoot(number);

		scanner.close();
	}

}
