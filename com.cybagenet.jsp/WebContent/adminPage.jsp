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
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp; <a href="logout.jsp">Logout</a>
	</div>

	<form>
		<br>
		<div align="center">
			<h2 align="center"
				style="font: monospace; font-family: cursive; color: olive;">ADMIN
				FUNCTIONALTIES</h2>
			<br> <input type="submit" value="Add Book" name="op"
				formaction="addBook.jsp" formmethod="post"> <input
				type="submit" value="Remove Book" name="op"
				formaction="removeBook.jsp" formmethod="post"> <input
				type="submit" value="Check User Log" name="op"
				formaction="getValidUser.jsp">
		</div>
	</form>

</body>
</html>