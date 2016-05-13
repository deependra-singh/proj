<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="bookBean" class="com.beans.BookBean"></jsp:useBean>

<%String bookName = request.getParameter("bookName");
String bookAuthor = request.getParameter("bookAuthor");
String bookPublisher = request.getParameter("bookPublisher");
if(bookName == null || bookAuthor == null || bookPublisher == null ){
%>

<div align="center">
		<form action="addBook.jsp" method="post">
			Enter book name: <input type="text" name="bookName"> Enter
			book author: <input type="text" name="bookAuthor"> Enter book
			publisher: <input type="text" name="bookPublisher"> <input
				type="submit" value="Add book">
		</form>
	</div>
<%}else if (bookName.length() != 0 || bookAuthor.length() != 0 || bookPublisher.length() != 0){
	bookBean.setBookName(bookName);
	bookBean.setBookAuthor(bookAuthor);
	bookBean.setBookPublisher(bookPublisher);
	
	if (!(bookBean.addBook())) {

		out.println(bookName);
%> added successfully
		<br><br> Wait until you are redirected to your home page..
<%		response.setHeader("Refresh", "2;adminPage.jsp");
	}
}
%>
</body>
</html>