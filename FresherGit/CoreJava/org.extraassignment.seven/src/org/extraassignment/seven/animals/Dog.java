package org.extraassignment.seven.animals;

public class Dog extends Animal {

	//OVERRIDING ABSTRACT METHOD OF BASE CLASS
	@Override
	public void respirate() {
		System.out.println("Dog is respirating");
	}
	
	//DOG'S OWN METHOD
	public void makeNoise() {

		System.out.println("Dog says bhaw bhaw...");

	}

	//DOG'S OWN METHOD
	public void eat()
	{
		System.out.println("Dog is chewing bone...");
	}
	
}
