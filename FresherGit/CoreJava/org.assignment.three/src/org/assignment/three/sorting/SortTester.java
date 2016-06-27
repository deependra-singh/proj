package org.assignment.three.sorting;

public class SortTester {

	public static void main(String[] args) {

		// store number of command line arguments
		int n = args.length;
		int array[] = new int[args.length];
		Sort sort = new Sort();

		for (int i = 0; i < n; i++) {
			// Parsing command line arguments to numeric values
			array[i] = Integer.parseInt(args[i]);
		}

		// calling sortArray method of Sort class
		sort.sortArray(array, n);
	}

}
