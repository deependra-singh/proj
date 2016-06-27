<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- GETTING USERNAME FROM SESSION -->
	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>
		<a href="logout.jsp">Logout</a>
	</div>

	<!-- CREATING BEAN INSTANCE OF BOOK BEAN -->
	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>

	<!-- GETTING SEARCH STRING FOR SEARCHING BOOK IN DATABASE -->
	<%
		String searchBookName = request.getParameter("bookName");
		String fullBookName = request.getParameter("book");
		System.out.print(fullBookName);
		if (searchBookName == null) {
	%>

	<!-- FORM TO GET SERACH STRING -->
	<div align="center">
		<form action="removeBook.jsp" method="post">
			<h3>Please enter book name to proceed further</h3>
			<br> <br> <input type="text" name="bookName"
				required="required"> <input type="submit" value="Remove">
		</form>
	</div>

	<!-- GETTING AND DISPLAYING BOOKS BASED ON SEARCH STRING -->
	<%
		} else if (fullBookName == null) {
			ResultSet rst = bookBean.searchBook(searchBookName);
	%>

	<!-- FORM FOR ADMIN TO CHOOSE A BOOK FROM DISPLAYED SET OF BOOKS -->
	<div align="center">
		<form action="removeBookFinal.jsp" method="post">
			<%
				while (rst.next()) {
			%>
			<br> <input type="radio" name="book" required="required"
				value="<%=rst.getString(1)%>">
			<%=rst.getString(1)%>
			<br>
			<%
				}
			%>
			<br>
			<input type="submit" name="op" value="Remove" />
		</form>
	</div>
	<%
		}
	%>

</body>
</html>