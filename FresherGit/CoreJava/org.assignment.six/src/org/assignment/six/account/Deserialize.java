package org.assignment.six.account;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author Deependra Singh
 * @purpose Serialize and de-serialize account object which will have Date type
 *          fieldname as dateOfCreation
 */

public class Deserialize {
	public void deserializeObject() {
		Account acct = null;
		try {
			// file from which object has to be read
			FileInputStream fis = new FileInputStream("D:/account.ser");
			ObjectInputStream in = new ObjectInputStream(fis);

			// read object
			acct = (Account) in.readObject();

			// print details of object
			System.out.println("details of account are" + acct.getBalance()
					+ acct.getName() + acct.stringDatOfCreation());
			
			in.close();

		} catch (Exception e) {

		}
	}

}
