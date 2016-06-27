package org.extraassignment.six.accountType;

public abstract class Account {

	private int accNo;
	private double currentBal;
	private String accType;
	private final double minBal=1000;
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public double getCurrentBal() {
		return currentBal;
	}
	public void setCurrentBal(double currentBal) {
		this.currentBal = currentBal;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getMinBal() {
		return minBal;
	}
	
	//ABTRACT METHOD TO FIND INTEREST
	public abstract double callInterest(double accBal);
	
}