package org.assignment.seven.members;

import org.assignment.seven.account.JointAccount;

/**
 * @author Deependra Singh
 * @purpose create joint account of two members trying to withdraw money from
 *          account at same time and using synchronization to resolve there
 *          problem.
 */

//second joint account
public class MemberOne extends JointAccount{

	@Override
	public void run() {
		super.run();
		//call withdraw method of joint account
		withdraw(3000);
	}
	

}
