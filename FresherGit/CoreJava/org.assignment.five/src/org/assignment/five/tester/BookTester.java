/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create a hashmap for the books and number of pages. Display contents
 * 			contents of map using iterator where book is a class. Also sort on
 * 			the basis of book-id
 */

package org.assignment.five.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.assignment.five.book.Book;
import org.assignment.five.book.BookSort;

public class BookTester {
	public static void main(String[] args) {

		// Create Map for Storing Books. Key is BookID and Value is obj of BOOK
		Map<Integer, Book> bookMap = new HashMap<Integer, Book>();

		// hard coded values inserted in Map
		bookMap.put(1, new Book(1, 400, "Test Your C++ Skills",
				"Yashvant Kanetkar"));
		bookMap.put(2, new Book(21, 350, "Test Your C", "Yashvant Kanetkar"));
		bookMap.put(3, new Book(13, 300, "Thinking in Java", "Kevin O' Brien"));
		bookMap.put(4, new Book(40, 400, "Let Us C", "Yashvant Kanetkar"));
		bookMap.put(5, new Book(5, 800, "Engineering Mathematics",
				"B.S. Grewal"));
		// bookMap.put(6, new Book(5, 800, "Engineering Mathematics",
		// "B.S. Grewal"));

		// Iterator to iterate over map using entry set.
		Iterator<Entry<Integer, Book>> bookIterator = bookMap.entrySet()
				.iterator();
		while (bookIterator.hasNext()) {
			Map.Entry<Integer, Book> entry = bookIterator.next();
			System.out.println(entry.getValue());
		}

		// Conversion of Map to List.
		List<Book> bookById = new ArrayList<Book>(bookMap.values());
		BookSort bs = new BookSort();

		// calling sortbyId method
		bs.sortBookById(bookById);

		System.out.println("\n\nThe sorted book according to ID is:");

		// for-each to display sorted books.
		for (Book book : bookById) {
			System.out.println(book);
		}

	}

}
