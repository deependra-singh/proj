package cyb.pojo;

public class BookPOJO {  
	
	private String bookTitle;
	private int bookId;
	private String bookAuthor;
	
	public BookPOJO(){
		
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public BookPOJO(String bookTitle, int bookId, String bookAuthor) {
		super();
		this.bookTitle = bookTitle;
		this.bookId = bookId;
		this.bookAuthor = bookAuthor;
	}
	
	
	

}
