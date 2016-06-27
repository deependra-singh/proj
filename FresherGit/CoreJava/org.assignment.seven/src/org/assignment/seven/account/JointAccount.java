package org.assignment.seven.account;

/**
 * @author Deependra Singh
 * @purpose create joint account of two members trying to withdraw money from
 *          account at same time and using synchronization to resolve there
 *          problem.
 */

public class JointAccount extends Thread{
	  static float balance = 5000;
	
	public static synchronized void withdraw(float amount){
		//check if balance is greater than amount
		if(amount < balance){
			//if yes then withdraw that amount
		balance = balance - amount ;
		System.out.println("balance is " + balance);
	}
		else{
		
			System.out.println("insufficient balance");
		}
	}
		
	

}
