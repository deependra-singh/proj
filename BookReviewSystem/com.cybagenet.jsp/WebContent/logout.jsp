<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="countBean" class="com.cybagenet.jsp.bean.CountBean"
		scope="application"></jsp:useBean>

	<%
		String userName = (String) session.getAttribute("loggedInUser");
		if (!(userName.equals("admin"))) {
			countBean.removeUser(userName);
		}
	%>

	<%
		session.invalidate();
	%>
	<div align="center">
		<h3>Thank you for visiting us!</h3>
		<h2>Successful log out</h2>
		<br> Redirecting you to login page
	</div>
	<%
		response.setHeader("Refresh", "3;index.jsp");
	%>
</body>
</html>