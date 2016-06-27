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

<!-- CREATING BEAN INSTANCE OF BOOK BEAN -->
	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>

	<!-- GETTING USERNAME FROM SESSION -->
	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp; <a href="logout.jsp">Logout</a>
	</div>

<!-- CALLING RESPECTIVE METHOD TO SEARCH BOOKS BASED ON SEARCH STRING AND DISPLAY THE SAME -->
	<%
		String searchBookName = request.getParameter("bookName");
		session.setAttribute("searchBook", searchBookName);
		ResultSet rst;
		rst = bookBean.searchBook((String) session.getAttribute("searchBook"));
	%>
	<div align="center">
		<form action="getReview.jsp">
			<%
				while (rst.next()) {
			%>
			<br> <input type="radio" name="fullBookName" required="required"
				value="<%=rst.getString(1)%>">
			<%=rst.getString(1)%>
			<br> <br>
			<%
				}
			%>
			
			<!-- DISPLAYING USER FUNCTIONALITIES AND FORWARDING REQUEST ACCORDINGLY -->
			<input type="submit" name="op" value="Get Details"
				formaction="getReview.jsp" formmethod="post"> &nbsp; <input
				type="submit" name="op" value="Add Review"
				formaction="addReview.jsp" formmethod="post">

		</form>
	</div>

</body>
</html>