package org.assignment.seven.utility;

import org.assignment.seven.members.MemberOne;
import org.assignment.seven.members.MemberTwo;

/**
 * @author Deependra Singh
 * @purpose create joint account of two members trying to withdraw money from
 *          account at same time and using synchronization to resolve there
 *          problem.
 */
public class JointAccountUtility {
	public static void main(String[] args) {
		// create first thread
		MemberOne m1 = new MemberOne();

		// create second thread
		MemberTwo m2 = new MemberTwo();

		// start first thread
		m1.start();

		// start second thread
		m2.start();

	}

}
