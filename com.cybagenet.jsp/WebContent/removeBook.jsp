<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="right">
		Hello:
		<%=session.getAttribute("loggedInUser")%>
		<a href="logout.jsp">Logout</a>
	</div>

	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>
	
	<%
	String searchBookName = request.getParameter("bookName");
	String fullBookName = request.getParameter("book");
	if (searchBookName == null){
		%>
		<div align="center">
		<form action="removeBook.jsp" method="post">
		<h3>Please enter book name to proceed further</h3>
		<br>
		<br>
		<br> <input type="text" name="bookName" required="required">
		<input
			type="submit" value="Remove">
		</form>
		</div>
		<%
	} else if (fullBookName == null){
		ResultSet rst = bookBean.searchBook(searchBookName);
		%>
		<form action = "removeBook.jsp" method = "post">
		<%
		while(rst.next()){
			%>
			<br>
			<input type = "radio" name = "book" required="required" value = "<%=rst.getString(1)%>"> <%=rst.getString(1)%>
			<br>
			<br>
			<%
		}
		%>
		<input type = "submit" name = "op" value = "Remove"/>
		</form>
		<%
		System.out.println(fullBookName);
	} else {
		System.out.println(fullBookName);
		if (!(bookBean.removeBook(fullBookName))){
			%>
			${param.book} is removed from database
			<br><br>Wait until you are redirected to your home page..
			<%
			response.setHeader("Refresh", "2;adminPage.jsp");
		}
	}
	%>

</body>
</html>