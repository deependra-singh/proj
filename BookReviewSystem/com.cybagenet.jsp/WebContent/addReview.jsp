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

	<!-- CREATING BEAN INSTANCE -->
	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>

	<!-- GETTING USERNAME FROM SESSION -->
	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp; <a href="logout.jsp">Logout</a>
	</div>

	<!-- DISPLAYING FORM TO GET REVIEWS OF BOOK FROM USER -->
	<%
		String oldReview = null;
		String newReview = request.getParameter("review");
		String bookName;
		if (newReview == null) {
	%>
	<br>
	<br>
	<div align="center">
		<form action="addReview.jsp" method="post" onsubmit="blur()">
			Enter Book Review: <input type="text" name="review"
				required="required" maxlength="200"> <input type="hidden"
				name="book" value="${param.fullBookName}"> <input
				type="submit" value="Submit">
		</form>
	</div>

	<!-- ADDING BOOK REVIEW BY CALLING RESPECTIVE METHOD IN BOOKBEAN -->
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
			bookBean.setNewBookReview(newReview, bookName);
	%>

	<!-- DISPLAYING MESSAGE OF SUCCESSFUL ADDITION OF REVIEW -->
	<div align="center">
		Review added successfully <br> <br> Wait until you are
		redirected to your home page
	</div>
	<%
		response.setHeader("Refresh", "3;userPage.jsp");
		} else {
	%>

	<!-- DISPLAYING MESSAGE TO ADD REVIEW IF LEFT BLANK -->
	<div align="center">Please enter some data and then enter.</div>
	<jsp:include page="addReview.jsp"></jsp:include>
	<%
		}
	%>

</body>
</html>