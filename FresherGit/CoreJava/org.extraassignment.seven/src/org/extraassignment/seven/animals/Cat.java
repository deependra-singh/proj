package org.extraassignment.seven.animals;

public class Cat extends Animal {

	//OVERRIDING METHOD OF BASE CLASS
	@Override
	public void respirate() {
		System.out.println("Cat is respirating");
	}
	
	//CAT'S OWN METHOD
	public void makeNoise() {

		System.out.println("Cat says meow meow...");

	}
	
	//CAT'S OWN METHOD
	public void eat()
	{
		System.out.println("Cat is drinking milk...");
	}

}
