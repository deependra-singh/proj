package org.utility;

import java.util.Scanner;
import org.squareroot.CalculateSquareRoot;

/**
 * @author Deependra Singh
 * @purpose Create a class calc inside a package utility. This class will have a
 *          method findRoot, which will return square root of given number.
 *          Create another class User1 inside the package allusers. USer1 calls
 *          the methods findRoot
 *
 */

public class Calc {

	public static void main(String[] args) {

		// enter number
		System.out.println("Enter number whose square root has to be found:");
		Scanner sc = new Scanner(System.in);
		double number = sc.nextDouble();
		
		//Instance of utility class to call the method responsible for calculating square root.
		Calc calc = new Calc();
		calc.findRoot(number);
		
		sc.close();
	}
	
	public void findRoot(double number){
		
		//Create the instance of the class having the calculate square root funda
		CalculateSquareRoot sq = new CalculateSquareRoot();

		// call method for calculating square root
		sq.calculateSquareRoot(number);
		
	}

}
