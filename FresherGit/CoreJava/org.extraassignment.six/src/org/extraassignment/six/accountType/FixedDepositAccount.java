package org.extraassignment.six.accountType;

public class FixedDepositAccount extends Account {

	private final double rateOfInterest = 5.5;

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
