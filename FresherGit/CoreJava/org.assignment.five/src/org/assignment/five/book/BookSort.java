/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create a hashmap for the books and number of pages. Display contents
 * 			contents of map using iterator where book is a class. Also sort on
 * 			the basis of book-id
 */

package org.assignment.five.book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSort {

	// method to sort books by ID.
	public void sortBookById(List<Book> bookById) {

		// using comparator books are being sorted
		Collections.sort(bookById, new Comparator<Object>() {

			@Override
			public int compare(Object book1, Object book2) {

				return ((Book) book1).getBookId().compareTo(
						((Book) book2).getBookId());

			}

		});
	}

}
