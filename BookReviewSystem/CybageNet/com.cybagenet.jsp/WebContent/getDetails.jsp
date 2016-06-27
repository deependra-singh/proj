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


	<%
		String bookName = request.getParameter("fullBookName");
		ResultSet rst;
		rst = bookBean.getBookDetails(bookName);
	%>

	<!-- 	DISPLAYING BOOK DETAILS -->
	<div align="center">
		<h3>
			Book details of <font color="blue"> <%
 	while (rst.next()) {
 %> <%=rst.getString(1)%></font>are
		</h3>
		Author:&npsb;<%=rst.getString(2)%>
		<br> <br> Publisher:&npsb;<%=rst.getString(3)%>
		<br> <br> Reviews:&npsb;
		<%
			if (rst.getString(4) != null) {
					String allReviews = rst.getString(4);
					String[] strArr = allReviews.split(",");
					for (int i = 0; i < strArr.length; i++) {
						out.println("<br>" + (i + 1) + " :- " + strArr[i]);
					}
		%>
	</div>
	<%
		}

			else {
	%>
	<br> No Reviews
	<%
		}
	%>
	<div align="right">
		<a href='userPage.jsp'>Go Back</a>
	</div>
	<%
		}
	%>

</body>
</html>