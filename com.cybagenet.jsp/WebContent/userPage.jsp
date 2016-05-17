<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage-Net</title>
</head>
<body>

	<jsp:useBean id="countBean" class="com.cybagenet.jsp.bean.CountBean"
		scope="application"></jsp:useBean>

	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp;
		<a href="logout.jsp">Logout</a>
	</div>

	<div align="center">
		<form action="searchBook.jsp" method="post">
			<h3>To search books, get details of book and add review for a
				book... Please enter book name:</h3>
			<input type="text" name="bookName" required="required"> <input
				type="submit" value="Search">
		</form>
	</div>

	<footer>
		<font color="blue">Site accessed till date by: <%=countBean.hitCount%></font>
	</footer>

</body>
</html>