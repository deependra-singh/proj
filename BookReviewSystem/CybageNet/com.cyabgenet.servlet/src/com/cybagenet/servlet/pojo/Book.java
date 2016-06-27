package com.cybagenet.servlet.pojo;

//BOOK POJO
public class Book {

	// PRIVATE DATA MEMBERS OF BOOK CLASS
	private int bookId;
	private String bookTitle;
	private String bookReview;
	private String bookAuthor;
	private String bookPublisher;

	// GETTERS AND SETTERS FOR THE DATA MEMBERS OF BOOK CLASS
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookReview() {
		return bookReview;
	}

	public void setBookReview(String bookReview) {
		this.bookReview = bookReview;
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

}
