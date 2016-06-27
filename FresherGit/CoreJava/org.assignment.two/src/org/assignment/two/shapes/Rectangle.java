package org.assignment.two.shapes;

public class Rectangle extends Shape {

	private float length, width;

	public Rectangle() {
		System.out.println("in rectangle's constructor");
	}

	public float getLength() {
		return length;
	}

	public float getWidth() {
		return width;
	}

	@Override
	public void calcArea(float length, float width) {
		System.out.println("calculate rectangle's area");
		float area = length * width;
		System.out.println("area=" + area);
	}

	@Override
	public void print() {
		System.out.println("in rectangle's printable");

	}

}
