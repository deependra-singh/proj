package org.assignment.two.shapes;

import org.assignment.two.printable.Printable;

public class Shape implements Printable {
	@SuppressWarnings("unused")
	private float area;

	public Shape() {
		System.out.println("in shape's constructor");
	}

	public void calcArea(float x, float y) {
		System.out.println("in shape's calc area");
	}

	@Override
	public void print() {
		System.out.println("in shape's printable");

	}

}
