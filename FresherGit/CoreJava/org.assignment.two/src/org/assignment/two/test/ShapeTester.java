package org.assignment.two.test;

import org.assignment.two.shapes.Circle;
import org.assignment.two.shapes.Rectangle;
import org.assignment.two.shapes.Shape;
import org.assignment.two.shapes.Triangle;

public class ShapeTester {

	public static void main(String[] args)
	{
		Shape[] shapes = {new Rectangle(), new Circle(), new Triangle()};
		shapes[0].calcArea(3.0f, 4.0f);
		shapes[1].calcArea(4.0f, 0.0f);
		shapes[2].calcArea(4.0f, 6.0f);
	}
}
