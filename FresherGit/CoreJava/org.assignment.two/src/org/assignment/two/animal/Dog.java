package org.assignment.two.animal;

public class Dog extends Animal {

	public Dog() {
		System.out.println("in dog's constructor");
	}

	@Override
	public void talk() {
		System.out.println("bow-wow");
	}

	@Override
	public void print() {
		System.out.println("in dog's's print");

	}

}
