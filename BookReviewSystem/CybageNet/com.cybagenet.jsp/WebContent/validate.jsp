<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage-Net</title>
</head>
<body>

	<!-- CREATING BEAN INSTANCE OF COUNT BEAN AND USER BEAN -->
	<jsp:useBean id="userBean" class="com.cybagenet.jsp.bean.UserBean"></jsp:useBean>
	<jsp:useBean id="countBean" class="com.cybagenet.jsp.bean.CountBean"
		scope="application"></jsp:useBean>

	<!-- GETTING THE TYPE OF USER(ADMIN/USER), USERNAME AND PASSWORD FOR VALIDATION -->
	<%
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		//BASED ON USER TYPE THE FOLLOWING PAGE IS DISPLAYED 
		switch (userType) {
		case "admin":
			if (userName.equals("admin") && password.equals("admin")) {
				session.setAttribute("loggedInUser", userName);
	%>
	<jsp:forward page="adminPage.jsp" />
	<%
		} else {
				out.println("Invalid username or password");
	%>
	<jsp:include page="index.jsp"></jsp:include>
	<%
		}
			break;

		default:
			//CALLING REPECTIVE METHOD FOR VALIDATION
			String result = userBean.validateUser(userName, password);
			if (result.equals("valid")) {
				countBean.addUser(userName);
				session.setAttribute("loggedInUser", userName);
	%>
	<jsp:forward page="userPage.jsp"></jsp:forward>
	<%
		} else {
				//DISPLAYING ERROR MESSAGE AND INCLUDING THE INDEX PAGE 
				out.println("Invalid username or password");
	%>
	<jsp:include page="index.jsp"></jsp:include>
	<%
		}
		}
	%>

</body>
</html>