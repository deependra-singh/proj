<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		String fullBookName = request.getParameter("book");
		if (!(bookBean.removeBook(fullBookName))) {
	%>
	${param.book} is removed from database
	<br>
	<br>Wait until you are redirected to your home page..
	<%
		response.setHeader("Refresh", "2;adminPage.jsp");
		}
	%>
</body>
</html>