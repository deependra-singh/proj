<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>&lt; fmt:formatDate&gt; Demo</title>

</head>
<body>
<h1>&lt; fmt:formatDate&gt; Demo</h1>
<c:set var="today" value="<%= new java.util.Date() %>"></c:set>
<p> Time: <strong> <fmt:formatDate type="time" value="${today}" /></strong> </p><br>
<p> Date: <strong> <fmt:formatDate type="date" value="${today}" /></strong> </p> <br>
<p>Date &  Time: <strong> <fmt:formatDate type="both" value="${today}" /></strong> </p><br>
<p> Date &  Time Short: <strong> <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${today}" /></strong> </p><br>
<p> Date &  Time Short: <strong> <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${today}" /></strong> </p><br>
<p> Date &  Time Short: <strong> <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${today}" /></strong> </p><br>
 <br> <br>
 <form action="sqlDemo.jsp" method="post">
<input type="submit" value="Click for sql tags">
</form>

</body>
</html>