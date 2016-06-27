<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage-Net</title>
</head>
<body>


	<!-- GETTING USERNAME FROM SESSION -->
	<div align="right">
		Hello
		<%=session.getAttribute("loggedInUser")%>&nbsp; <a href="logout.jsp">Logout</a>
	</div>

	<!-- CREATING BEAN INSTANCE -->
	<jsp:useBean id="bookBean" class="com.cybagenet.jsp.bean.BookBean"></jsp:useBean>

	<!-- GETTING BOOK DETAILS FROM FORM -->
	<%
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPublisher = request.getParameter("bookPublisher");
		if (bookName == null || bookAuthor == null || bookPublisher == null) {
	%>

	<!-- 	FORM TO GET DETAILS OF BOOK -->
	<div align="center">
		<form action="addBook.jsp" method="post">
			<fieldset>
				<legend>Book Details</legend>
				<table>
					<tr>
						<td>Enter book name:</td>
						<td><input type="text" name="bookName" required="required"></td>
					</tr>

					<tr>
						<td>Enter book author:</td>
						<td><input type="text" name="bookAuthor" required="required"></td>
					</tr>

					<tr>
						<td>Enter book publisher:</td>
						<td><input type="text" name="bookPublisher"
							required="required"></td>
					</tr>

					<tr>
						<td></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Add book"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

	<!-- CHECKING IF BOOK ADDED SUCCESSFULLY -->
	<%
		} else {
			if (!(bookBean.addBook(bookName, bookAuthor, bookPublisher))) {
	%>
	<br>

	<!-- DISPLAYING MESSSAGE OF SUCCESSFUL ADDITION OF BOOK TO DATABASE -->
	<div align="center">
		${param.bookName} added successfully <br> <br> Wait until
		you are redirected to your home page..
		<%
 	response.setHeader("Refresh", "2;adminPage.jsp");
 		}
 	}
 %>
	</div>
</body>
</html>