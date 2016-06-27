package org.assignment.two.shapes;

public class Triangle extends Shape{
	private float base, height;

	public Triangle() {
		System.out.println("in triangle's constructor");
	}

	public float getBase() {
		return base;
	}

	public float getHeight() {
		return height;
	}
	
	@Override
	public void calcArea(float base, float height)
	{
		System.out.println("calculate traingle's area:");
		float area = 0.5f*base*height; 
		System.out.println("area="+area);
	}
	
	@Override
	public void print() {
		System.out.println("in triangle's printable");
		
	}


}
