package org.assignment.two.test;

import java.util.Scanner;

import org.assignment.two.animal.Animal;
import org.assignment.two.animal.Cat;
import org.assignment.two.animal.Dog;
import org.assignment.two.animal.Lion;

public class AnimalTester {

	public static void main(String[] args) {
		// Array of animal references
		Animal[] animals = { new Lion(), new Cat(), new Dog(), new Animal() };

		// set number of legs for cat
		animals[1].setNumOfLegs(4);

		// print number of legs
		System.out.println(animals[1].getNumOfLegs());
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter colour of fur");
		String fur = sc.next();
		((Cat) animals[1]).setColorFur(fur);
		System.out.println(((Cat) animals[1]).getColorFur());

		animals[0].talk();
		animals[0].print();
		animals[1].talk();
		animals[2].talk();
		animals[3].talk();

		sc.close();
	}

}
