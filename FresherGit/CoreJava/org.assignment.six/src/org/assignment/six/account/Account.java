package org.assignment.six.account;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Deependra Singh
 * @purpose Serialize and de-serialize account object which will have Date type
 *          fieldname as dateOfCreation
 */

@SuppressWarnings("serial")
public class Account implements Serializable {

	private String name;
	private float balance;
	private Date dateOfCreation;

	public String getName() {
		return name;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public String stringDatOfCreation() {

		SimpleDateFormat newsdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDtae = newsdf.format(getDateOfCreation());
		return strDtae;

	}

	public float getBalance() {
		return balance;
	}

	public Account() {

	}

	public Account(String name, float balance, String string)
			throws ParseException {
		super();
		this.name = name;
		this.balance = balance;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date string1 = sdf.parse(string);
		this.dateOfCreation = string1;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance
				+ ", dateOfCreation=" + stringDatOfCreation() + "]";
	}

}
