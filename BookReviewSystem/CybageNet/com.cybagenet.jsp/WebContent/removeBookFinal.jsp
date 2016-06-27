<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- GETTING USERNAME FROM SESSION -->
	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp; <a href="logout.jsp">Logout</a>
	</div>

	<!-- CREATING BEAN INSTANCE OF BOOK BEAN -->
	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>

	<!-- CALLING RESPECTIVE METHOD TO REMOVE BOOK FROM DATABASE -->
	<%
		String fullBookName = request.getParameter("book");
		if (!(bookBean.removeBook(fullBookName))) {
	%>
	<br>

	<!-- 	DISPLAYING MESSAGE OF SUCCESSFUL REMOVAL OF BOOK FROM DATABASE -->
	<div align="center">
		${param.book} is removed from database <br>

		<!-- REDIRECTING ADMIN TO HIS HOME PAGE -->
		<br>Wait until you are redirected to your home page..
		<%
			response.setHeader("Refresh", "2;adminPage.jsp");
			}
		%>
	</div>
</body>
</html>