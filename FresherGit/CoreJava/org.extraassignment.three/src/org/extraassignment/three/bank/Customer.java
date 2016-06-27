package org.extraassignment.three.bank;

public class Customer {

	private String name;
	private String address;
	private static int accNo = 1 ;
	private double accBal;

	public Customer(String name, String address, double accBal) {
		super();
		this.name = name;
		this.address = address;
		this.accBal = accBal;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer name: " + name + ", address: " + address + ", accNo: "
				+ accNo + ", accBal: " + accBal;
	}

	//GETTER SETTER FOR ACCOUNT NUMBER
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo() {
		this.accNo = accNo++;
		
	}
	
}
