<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="rest/student" method="post">
	 Name:&nbsp;&nbsp;<input type="text" name="name">
	Roll:&nbsp;&nbsp;<input type="text" name="id"> 
	<input type="submit" name="test">
	</form>
</body>
</html>