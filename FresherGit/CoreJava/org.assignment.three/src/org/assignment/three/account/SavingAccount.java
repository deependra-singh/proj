package org.assignment.three.account;

public class SavingAccount extends Account {

	private final float rateOfInterest = 0.06f ;
	
	public SavingAccount(String name, float balance) {
		super(name, balance);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("in saving's finalize");
		super.finalize();
	}
	
	@Override
	public void calculateBalance() {
		float grossBalance = getBalance() + (getBalance()*rateOfInterest);
		}

}
