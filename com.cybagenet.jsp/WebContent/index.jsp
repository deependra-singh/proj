<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage-Net</title>
</head>
<body>
	<div align="center">
		<form action="validate.jsp" method="post">

			<h1 align="center">WELCOME TO CYBAGE NET</h1>
			<input type="radio" name="userType" value="admin">Admin <input
				type="radio" name="userType" value="user" checked="checked">User

			<br> Enter Username : <input type="text" name="userName"
				required="required" /><br> <br> Enter Password : <input
				type="password" name="password" required="required" /><br> <br>
			<input type="submit" value="Submit">

		</form>
	</div>
</body>
</html>