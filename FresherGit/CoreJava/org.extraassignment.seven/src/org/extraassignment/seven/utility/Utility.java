package org.extraassignment.seven.utility;

import org.extraassignment.seven.animals.Animal;
import org.extraassignment.seven.animals.Cat;
import org.extraassignment.seven.animals.Dog;

public class Utility {

	public static void main(String[] args) {

		//GENERATING ARRAY OF OBJECTS OF ANIMAL REFERNECE
		Animal[] animals = { new Cat(), new Dog()};
		animals[0].respirate();
		animals[1].respirate();
		
		//CASTING ANIMAL TO CAT AND DOG SO THAT THE LATTER'S makeNoise() METHOD IS CALLED
		((Cat) animals[0]).makeNoise();
		((Dog) animals[1]).makeNoise();

		//CASTING ANIMAL TO CAT AND DOG SO THAT THE LATTER'S eat() METHOD IS CALLED
		((Cat) animals[0]).eat();
		((Dog) animals[1]).eat();

	}

}
