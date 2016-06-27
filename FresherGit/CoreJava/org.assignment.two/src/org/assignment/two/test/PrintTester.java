package org.assignment.two.test;

import org.assignment.two.animal.Cat;
import org.assignment.two.animal.Lion;
import org.assignment.two.printable.Printable;
import org.assignment.two.shapes.Circle;
import org.assignment.two.shapes.Rectangle;
import org.assignment.two.shapes.Shape;
import org.assignment.two.util.*;

public class PrintTester {

	public static void main(String[] args) {
		Utility u = new Utility();
		Printable[] print = new Printable[5];
		print[0] = new 	Lion();
		print[1] = new 	Circle();
		print[2] = new 	Cat();
		print[3] = new 	Shape();
		print[4] = new 	Rectangle();
		
		u.printAll(print);
		
	}
}
