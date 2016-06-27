package org.extraassignment.six.accountType;

public class CurrentAccount extends Account {

	private final double rateOfInterest = 6f;

	//OVERRIDING ABSTRACT METHOD OF BASE CLASS
	@Override
	public double callInterest(double accBal) {
		if (accBal > 1000)
			return 0.01 * rateOfInterest * accBal;
		else
			System.out
					.println("interest not applicable as balance is less than minimum balance");
		return 0;
	}

}
