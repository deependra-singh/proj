<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- Select your Programming Language: -->
<body>
<h1> for-each Demo</h1>
<form  action="${pageContext.request.contextPath}/jstldemo.jsp" method="post">

 <input type="checkbox" name="option"  value="C">C <br>
<input type="checkbox" name="option"  value="C++">C++ <br>
<input type="checkbox" name="option"  value="Java">Java <br>
<input type="checkbox" name="option"  value="PHP">PHP <br>
<input type="submit" value="Submit">

<c:forEach var = "option" items="${paramValues.option }" >
<c:out value="${option}"></c:out></c:forEach>
</form>
<br> <br>
<form action="jstlFormat.jsp" method="post">
<input type="submit" value="Click for format tags">
</form>

</body>
</html>