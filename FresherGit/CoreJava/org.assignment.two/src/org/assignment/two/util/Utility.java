package org.assignment.two.util;

import org.assignment.two.printable.Printable;

public class Utility implements Printable{
	
	public void printAll(Printable[] p){
		for(int i=0; i< p.length; i++){
			p[i].print();
		}
	}

	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String toString() {
		return "Utility []";
	}

	
}
