package org.assignment.three.test;

import org.assignment.three.account.Account;
import org.assignment.three.account.SavingAccount;

public class Tester {
	public static void main(String[] args){
		Account a1= new SavingAccount("Preeti", 4000);
		Account a2 = new SavingAccount("Raju", 4000);
		Account a3 = new SavingAccount("Raju", 8000);
		
		//Checking overriden equals method
		System.out.println(a1.equals(a2));
		System.out.println(a2.equals(a3));
				
		//checking overriden toString method
		System.out.println(a1);
		
		//Checking finalize method
		a1 = null ;
		System.gc();
		
		
	}

}
