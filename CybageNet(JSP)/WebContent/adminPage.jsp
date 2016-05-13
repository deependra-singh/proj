<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form>
		<br> <br> <br>
		<center>
			<input type="submit" value="Add Book" name="op"
				formaction="addBook.jsp"> 
				<input type="submit"
				value="Remove Book" name="op" formaction="removeBook.jsp">
				 <input
				type="submit" value="Check User Log" name="op"
				formaction="getValidUser.jsp">
		</center>
	</form>
	<br>
	<br>
	<h3 align="right">
		<a href=logout.jsp>Logout</a>
	</h3>

</body>
</html>