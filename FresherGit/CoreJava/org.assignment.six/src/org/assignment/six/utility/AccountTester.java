package org.assignment.six.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.assignment.six.account.Account;
import org.assignment.six.account.Deserialize;
import org.assignment.six.account.Serialize;

/**
 * @author Deependra Singh
 * @purpose Serialize and de-serialize account object which will have Date type
 *          fieldname as dateOfCreation
 */
public class AccountTester {
	public static void main(String[] args) throws ParseException {
		Account account = null;

		// simple date format to give form at of date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = sdf.parse("1-07-1989");
		try {
			// account object is created
			account = new Account("Ramesh", 10000, sdf.format(date1));
			System.out.println(account);

			// call serializeObject method of Serialize class
			Serialize s = new Serialize();
			s.serializeObject(account);
		}

		catch (Exception e) {
		}

		// call deserializeObject method of deserialize class
		Deserialize ds = new Deserialize();
		ds.deserializeObject();

	}
}