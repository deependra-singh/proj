<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bookBean" class="com.beans.BookBean"></jsp:useBean>

<%
ResultSet rst;
String fullBookName = request.getParameter("book");
if(fullBookName == null)
{
%>

<jsp:setProperty property="bookName" name="bookBean" value="${param.bookName}"/>

<%	
rst = bookBean.searchBook();
%>
<form action = "remove.jsp" method = "post">
<%
while (rst.next()) {
	%>
	<br><input type = "radio" name = "book" value = "<%=rst.getString(1)%>"> <%=rst.getString(1)%>
	<br>
	<br>
<%}
%>
<input type = "submit" name = "op" value = "Remove"/>
<%
}else if(fullBookName.length() != 0) {
%>		
		<jsp:setProperty property="bookName" name="bookBean" value="${param.book}"/>	
		
<%		
if (!(bookBean.removeBook())) {

	out.println( fullBookName);
%>	
	is removed from database

	<br><br>Wait until you are redirected to your home page..
<%
	response.setHeader("Refresh", "2;adminPage.jsp");
}}
	
	
	%>
</form>
</body>
</html>