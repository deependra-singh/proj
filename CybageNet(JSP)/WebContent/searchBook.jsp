<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bookBean" class="com.beans.BookBean"></jsp:useBean>

	<div align="right">
		Hello:
		<%= session.getAttribute("username") %>
		<a href="logout.jsp" style="margin-left: 20px">Logout</a>
	</div>

	<%
	ResultSet rst;
	%>

	<jsp:setProperty property="bookName" name="bookBean"
		value="${param.bookName}" />

	<% rst = bookBean.searchBook(); %>

	<form action="getReview.jsp" method="post">
		<%
		while (rst.next()) {	
		%>
		<br> <input type="radio" name="book"
			value="<%=rst.getString(1)%>">
		<%=rst.getString(1)%>
		<br> <br>
		<%	
			}
		%>

		<input type="submit" name="op" value="Get Details" /> <input
			type="submit" name="op" value="Add Review" />
	</form>
</body>
</html>