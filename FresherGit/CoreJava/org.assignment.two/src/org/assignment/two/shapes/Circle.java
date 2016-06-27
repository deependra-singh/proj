package org.assignment.two.shapes;

public class Circle extends Shape {

	@SuppressWarnings("unused")
	private float radius;

	public Circle() {
		System.out.println("in circle's construstor");
	}

	@Override
	public void calcArea(float radius, float r) {
		System.out.println("calculate circle's area:");
		float area = 3.14f * radius * radius;
		System.out.println("area=" + area);
	}

	@Override
	public void print() {
		System.out.println("in circle's print");

	}

}
