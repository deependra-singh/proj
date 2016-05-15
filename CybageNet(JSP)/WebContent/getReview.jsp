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

	<jsp:useBean id="bookBean" class="com.beans.BookBean" scope="session"></jsp:useBean>
	<jsp:useBean id="userBean" class="com.beans.UserBean"></jsp:useBean>

	<div align="right">
		Hello:
		<jsp:getProperty property="userName" name="userBean"/>
		<a href="logout.jsp" style="margin-left: 20px">Logout</a>
	</div>

	<%
		ResultSet rst;
		if (request.getParameter("book") != null) {
			request.getSession(false);
			session.setAttribute("bookname", request.getParameter("book"));
	%>

	<jsp:setProperty property="bookName" name="bookBean"
		value="${param.book}" />

	<%
		String option = request.getParameter("op");
			switch (option) {
			case "Get Details":
				rst = bookBean.getBookDetails();
	%>
	<h3>Book Details of
	<%
				while (rst.next()) {
	%>
					<%=rst.getString(1)%>
					are</h3>
					<br> Author:
					<%=rst.getString(2)%><br> Publisher:
					<%=rst.getString(3)%><br> Reviews:
					<%
					if (rst.getString(4) != null) {
						String allReviews = rst.getString(4);
						String[] strArr = allReviews.split(",");
						for (int i = 0; i < strArr.length; i++) {
							out.println("<br>" + (i + 1) + " :- " + strArr[i]);
						}
					} else {
	%>
					<br>No reviews
	<%
					}
	%>
					<div align="right">
						<a href='userPage.jsp'>Go Back</a>
					</div>
	<%
				}
				break;
			case "Add Review":
	%>
				<jsp:forward page="addReview.jsp"></jsp:forward>
	<%
		}
	}
	%>
</body>
</html>