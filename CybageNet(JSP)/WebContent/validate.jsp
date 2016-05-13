<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userBean" class="com.beans.UserBean"></jsp:useBean>
	<%
		String userType = request.getParameter("userType");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("pass");
		session.setAttribute("username", name);
 	%>

	<jsp:setProperty name="userBean" property="*" />

	<%	
		switch (userType) {
		case "admin":
			if (name.equals("admin") && pwd.equals("admin")) {
	%>

	<jsp:forward page="adminPage.jsp" />

	<%
			} else {
				out.print("Invalid password");
	%>

	<jsp:include page="index.jsp" />

	<%
			}
			break;

		 default:
			String result = userBean.authenticateUser();
			if (result.equals("valid")) {
	%>

	<jsp:forward page="userPage.jsp"></jsp:forward>

	<%
			} else {
	%>

	<jsp:include page="index.jsp" />

	<% 		
			}
			break;
		}	 
	%>
</body>
</html>