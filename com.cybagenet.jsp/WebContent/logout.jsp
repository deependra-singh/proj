<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% session.invalidate(); %>
	<h2>Successful log out</h2>
	<% response.setHeader("Refresh", "3;index.jsp"); %>
</body>
</html>