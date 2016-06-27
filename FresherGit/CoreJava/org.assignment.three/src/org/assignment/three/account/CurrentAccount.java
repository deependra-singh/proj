package org.assignment.three.account;

public class CurrentAccount extends Account {
	
	
private final float rateOfInterest = 0.04f ;
	
	public CurrentAccount(String name, float balance) {
		super(name, balance);
	}
	
	@Override
	public void calculateBalance() {
		float grossBalance = getBalance() + (getBalance()*rateOfInterest);
		}

}
