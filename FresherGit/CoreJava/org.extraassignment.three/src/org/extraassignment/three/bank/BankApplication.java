package org.extraassignment.three.bank;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {

	private Customer cust;
	private Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

	//METHOD TO ADD CUSTOMER IN THE MAP
	public int addCustomer(Customer customer) {
		customer.setAccNo();
		customers.put(customer.getAccNo(), customer);
		return customer.getAccNo();
	}

	//METHOD TO GET CUSTOMER DETAILS USING ACCOUNT NUMBER
	public Customer getCustomerInfo(int accNo) {
		Customer cust = customers.get(accNo);
		return cust;
	}

	//METHOD TO REMOVE CUSTOMER USING ACCOUNT NUMBER
	public Customer deleteCustomer(int accNo) {
		customers.remove(accNo);
		return cust;
	}

	//METHOD TO UPDATE CUSTOMER DETAILS USING ACCOUNT NUMBER
	public String updateCustomer(int accNo,String address) {
		Customer customer = customers.get(accNo);
		customer.setAddress(address);
		return "successfully";
	}

	//METHHOD TO VALIDATE ACCOUNT NUMBER ENTERED
	public boolean validateAccount(int accNo) {
		if (!customers.containsKey(accNo))
			return false;
		return true;
	}

}
