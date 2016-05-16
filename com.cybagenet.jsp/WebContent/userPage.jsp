<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage-Net</title>
</head>
<body>

	<div align="right">
		Hello:
		<%=session.getAttribute("loggedInUser")%>
		<a href="logout.jsp">Logout</a>
	</div>

	<div align="center">
		<form action="searchBook.jsp" method="post">
			<h3>To search books, get details of book and add review for a
				book... Please enter book name:</h3>
			<input type="text" name="bookName" required="required"> <input
				type="submit" value="Search">
		</form>
	</div>

</body>
</html>