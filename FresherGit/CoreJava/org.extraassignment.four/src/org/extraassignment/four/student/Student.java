/**
 * @author Deependra Singh
 * 
 * @purpose class student and show polymorphism with age parameter
 */

package org.extraassignment.four.student;

public class Student {

	private int id;
	private String name;
	private int age;

	// METHOD WITH TWO PARAMETERS(ID AND NAME) TO SET DATA
	public void setData(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("ID and name of student saved");
	}

	// OVERLOADED METHOD WITH THREE PARAMETERS(ID, NAME AND AGE) TO SET DATA
	public void setData(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		System.out.println("ID,name and age of student saved");
	}

}
