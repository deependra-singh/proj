<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First</title>
</head>
<body>
<%
String uname = request.getParameter("uname");
String pass = request.getParameter("pass");

session.setAttribute("uname",uname);
if(uname.equals("ashwin") && pass.equals("123"))
{
%>
<h1 align="center">Hello 
<%
out.println(uname);
%>
</h1>
<h3 align="center">
<% for(int i=1;i<=10;i++) 
{
	out.println("13 *"+i +"="+(13*i)+"");
%>
<br>
<%
}

%>
<a href = "Logout.jsp">Next Page</a>
</h3>



<%
}
else
{
out.println("INVALID USERNAME OR PASSWORD");
RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
rd.include(request, response);
}
%>

</body>
</html>