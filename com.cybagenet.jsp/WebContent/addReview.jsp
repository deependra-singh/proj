<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage-Net</title>
</head>
<body>

	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>
	
	<div align="right">
		Hello:
		<%=session.getAttribute("loggedInUser")%>
		<a href="logout.jsp">Logout</a>
	</div>
	
	<%
	String oldReview = null;
	String newReview = request.getParameter("review");
	String bookName;
	if (newReview == null) {
	%>
		<form action="addReview.jsp" method="post" onsubmit="blur()">
			Enter Book Review: <input type="text" name="review" required="required">
			<input type="hidden" name="book" value="${param.fullBookName}">
			<input type="submit" value="Submit">
		</form>
	<%
		} else if (newReview.length() != 0) {
			bookName = request.getParameter("book");
			ResultSet rs = bookBean.getOldBookReview(bookName);
			while (rs.next()) {
				oldReview = rs.getString(1);
			}

			if (oldReview == null)
				newReview = request.getParameter("review");
			else
				newReview = oldReview.concat(",").concat(request.getParameter("review"));
			bookBean.setNewBookReview(newReview,bookName);
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