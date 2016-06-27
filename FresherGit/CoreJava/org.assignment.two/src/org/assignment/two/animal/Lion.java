package org.assignment.two.animal;

public class Lion extends Animal {

	public Lion() {
		System.out.println("in lion's constructor");
	}

	@Override
	public void talk() {
		System.out.println("roar-roar");
	}

	@Override
	public void print() {
		System.out.println("in lion's print");

	}

}
