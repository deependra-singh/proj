package com.runsignal;

import com.signal.Signal;
import com.way.Way;

public class RunSignal {

	public static void main(String[] args) {
	
		Signal sig = new Signal();
		Way way1 = new Way(0, sig);
		Way way2 = new Way(1, sig);
		Way way3 = new Way(2, sig);
		Way way4 = new Way(3, sig);
		//Way way5 = new Way(4, sig);

	}

}
