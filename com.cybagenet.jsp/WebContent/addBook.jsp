<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="right">
		Hello:
		<%=session.getAttribute("loggedInUser")%>
		<a href="logout.jsp">Logout</a>
	</div>

	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>
	
	<%
	String bookName = request.getParameter("bookName");
	String bookAuthor = request.getParameter("bookAuthor");
	String bookPublisher = request.getParameter("bookPublisher");
	if(bookName == null || bookAuthor == null || bookPublisher == null ){
		%>
		<div align="center">
			<form action="addBook.jsp" method="post">
				Enter book name: <input type="text" name="bookName" required="required">
				Enter book author: <input type="text" name="bookAuthor" required="required">
				Enter book publisher: <input type="text" name="bookPublisher" required="required">
				<input type="submit" value="Add book">
			</form>
		</div>
		<%
	} else {
		if (!(bookBean.addBook(bookName, bookAuthor, bookPublisher))){
	%>
			${param.bookName} added successfully<br>
			<br> Wait until you are redirected to your home page..
	<%
			response.setHeader("Refresh", "2;adminPage.jsp");
		}
	}
	%>

</body>
</html>