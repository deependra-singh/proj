package org.assignment.three.account;

public class Account {
	private String name;
	private float balance;
	
	
	
	public Account(String name, float balance) {
		super();
		this.name = name ;
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	public void calculateBalance(){
		}

	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("in account's finalize");
	}
	

}
