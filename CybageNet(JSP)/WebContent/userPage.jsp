<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="right">
Hello: 
<%=
session.getAttribute("username")
%>
<a href="logout.jsp" style="margin-left: 20px">Logout</a>
</div>
	<form action="searchBook.jsp" method="get">
		<br> <br> <br>
		<div align="center">
			<h3 align="center">To search books, get details of book and add
				review for a book... Please enter book name:</h3>
			<input type="text" name="bookName"> <input type="submit"
				value="Search">
		</div>
	</form>
	<br>
	<br>
</body>
</html>