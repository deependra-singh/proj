<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp;
		<a href="logout.jsp">Logout</a>
	</div>

	<jsp:useBean id="countBean" class="com.cybagenet.jsp.bean.CountBean"
		scope="application"></jsp:useBean>

	<%
		int users = countBean.userCount();
		if (users > 0) {
	%>
	<br><div align="center"><h3>
		Currently
		<%=users%>
		users are logged in
	</h3></div>
	<%
		} else {
	%>
	<div align="center"><h3>Currently 0 users are logged in</h3></div>
	<%
		}
	%>

</body>
</html>