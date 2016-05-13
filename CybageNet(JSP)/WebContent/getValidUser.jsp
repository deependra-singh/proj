<%@page import="com.listeners.SessionCounter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

int noOfUsers = SessionCounter.getTotalActiveSessions();

if(noOfUsers == 0)
{
%>
	<h3>Currently no user is logged in</h3>
<%
}
else
{
	System.out.print(noOfUsers);
	%>

	<h3>Currently <%=((noOfUsers) - 1) %> user(s) are logged in...</h3>

<%}
%>
<div align="right">
<h4><a href = "adminPage.jsp"> Go back </a><h4>
<h4><a href = "logout.jsp"> Logout </a><h4>
</div>
</body>
</html>