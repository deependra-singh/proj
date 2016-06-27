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

	<div align="center">

		<h1 align="center"
			style="font: monospace; font-family: cursive; color: teal;">WELCOME
			TO CYBAGE NET</h1>

		<form action="validate.jsp" method="post">
			<table>
				<tr>
					<td colspan="2" align="center"><input type="radio"
						name="userType" value="admin">Admin <input type="radio"
						name="userType" value="user" checked="checked">User</td>
				</tr>

				<tr>
					<td>Enter Username :</td>
					<td><input type="text" name="userName" required="required" /></td>
				</tr>

				<tr>
					<td>Enter Password :</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>

	<footer>
		<font color="blue">Site accessed till date by <%=countBean.hitCount%>
			users
		</font>
	</footer>
</body>
</html>