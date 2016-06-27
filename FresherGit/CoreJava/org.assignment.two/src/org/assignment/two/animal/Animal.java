package org.assignment.two.animal;

import org.assignment.two.printable.Printable;

public class Animal implements Printable {
	private int numOfLegs;

	public int getNumOfLegs() {
		return numOfLegs;
	}

	public void setNumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}

	public Animal() {
	}

	public void respirate() {
		System.out.println("in animal's respirate");
	}

	public void talk() {
		System.out.println("in animal's talk");
	}

	@Override
	public void print() {
		System.out.println("in animal's print");

	}

}
