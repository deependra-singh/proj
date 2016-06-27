<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cust" class="bean.CustomerBean" ></jsp:useBean>
<jsp:setProperty name="cust" property="*"/>

<h1 align="center">
welcome  <jsp:getProperty property="fname" name="cust"/>  <jsp:getProperty property="lname" name="cust"/><br>

Contact number :  <jsp:getProperty property="contactNumber" name="cust"/> <br>
Customer Id :  <jsp:getProperty property="id" name="cust"/><br>
Address :  <jsp:getProperty property="address" name="cust"/><br>
</h1>
</body>
</html>