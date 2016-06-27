package org.assignment.two.animal;

public class Cat extends Animal {
	private String colorFur;

	public String getColorFur() {
		return colorFur;
	}

	public void setColorFur(String colorFur) {
		this.colorFur = colorFur;
	}

	public Cat() {
		System.out.println("in cat's constructor");
	}

	@Override
	public void talk() {
		System.out.println("meow-meow");
	}

	@Override
	public void print() {
		System.out.println("in cat's print");

	}

}
