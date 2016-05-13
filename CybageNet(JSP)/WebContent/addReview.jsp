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
	<jsp:setProperty property="bookName" name="bookBean" value="${param.book}"/>
	
	<%
		String oldReview = null;
		String newReview = request.getParameter("review");
		if (newReview == null) {
	%>
	<form action="addReview.jsp" method="post" onsubmit="blur()">
		Enter Book Review: <input type="text" name="review"> <input
			type="submit" value="Submit">
	</form>

	<%
		} else if (newReview.length() != 0) {
	%>
	<%
			bookBean.setBookName((String) session.getAttribute("bookname"));
			ResultSet rs = bookBean.getOldBookReview();
			while (rs.next()) {
				oldReview = rs.getString(1);
			}
		

			if (oldReview == null)
				newReview = request.getParameter("review");
			else
				newReview = oldReview.concat(",").concat(request.getParameter("review"));
			bookBean.setNewBookReview(newReview);
	%>
	Review added successfully
	<br>
	<br> Wait until you are redirected to your home page...
	<%
		response.setHeader("Refresh", "3;userPage.jsp");
		} else {
	%>
	Please enter some data and then enter.
	<jsp:include page="addReview.jsp"></jsp:include>
	<%
		}
	%>
</body>
</html>