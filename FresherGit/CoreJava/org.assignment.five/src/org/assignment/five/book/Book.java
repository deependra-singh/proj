/*
 * Author: Deependra Singh
 * Purpose: Assignment number 5
 * 			Create a hashmap for the books and number of pages. Display contents
 * 			contents of map using iterator where book is a class. Also sort on
 * 			the basis of book-id
 */

package org.assignment.five.book;

public class Book {
	private int bookId, numberOfPages;
	private String bookName, bookAuthor;

	// Constructor
	public Book(int bookId, int numberOfPages, String bookName,
			String bookAuthor) {
		super();
		this.bookId = bookId;
		this.numberOfPages = numberOfPages;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	// getter for number of pages
	public int getNumberOfPages() {
		return numberOfPages;
	}

	// getter for Book Name
	public String getBookName() {
		return bookName;
	}

	// getter for Book Author
	public String getBookAuthor() {
		return bookAuthor;
	}

	// getter for Book ID
	public Integer getBookId() {
		return bookId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + numberOfPages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", numberOfPages=" + numberOfPages
				+ ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}

}
