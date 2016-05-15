package com.beans;

import com.dao.BookDAO;
import java.sql.ResultSet;

public class BookBean {

	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String bookReview;
	private BookDAO book = new BookDAO();

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookReview() {
		return bookReview;
	}

	public void setBookReview(String bookReview) {
		this.bookReview = bookReview;
	}

	public ResultSet searchBook() {
		return book.searchBook(bookName);
	}

	public ResultSet getBookDetails() {
		return book.getBookDetails(bookName);
	}

	public ResultSet getOldBookReview() {
		System.out.println(bookName);
		return book.getOldBookReview(bookName);
	}

	public boolean setNewBookReview(String newReview) {
		return book.setNewBookReview(newReview, bookName);
	}

	public boolean addBook() {
		return book.addBook(bookName, bookAuthor, bookPublisher);
	}

	public boolean removeBook() {
		return book.removeBook(bookName);
	}
}