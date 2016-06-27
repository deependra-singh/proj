package org.assignment.six.account;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author Deependra Singh
 * @purpose Serialize and de-serialize account object which will have Date type
 *          fieldname as dateOfCreation
 */

public class Serialize {
	public void serializeObject(Account account) {
		try {
			// file to which object has to be serialized
			FileOutputStream fos = new FileOutputStream("D:/account.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);

			// write that object to the file
			out.writeObject(account);

			// close resources
			out.close();
			fos.close();
			System.out.println("object has been serialized and save");

		} catch (Exception e) {

		}
	}
}
