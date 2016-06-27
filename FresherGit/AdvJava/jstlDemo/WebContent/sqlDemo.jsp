<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/sqlDemo.jsp" method="post">
<table>


<tr> <td> Enter Employee Id: </td> <td> <input type="text" name="id"></td> </tr>
<tr> <td> Enter Employee Name: </td> <td> <input type="text" name="name"></td> </tr>
<tr> <td> Enter Employee Salary: </td> <td> <input type="text" name="salary"></td> </tr>
<tr> <td> <input type="submit" value="Submit"></td></tr>
</table>
</form>

<sql:setDataSource var="java" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/java" user="root" password="root"/>

<c:choose>
<c:when test="${not empty param.id && not empty param.name && not empty param.salary }">
<sql:update dataSource="${java}" var="emp">
Insert into employee values(?,?,?)
<sql:param value="${param.id}"></sql:param>
<sql:param value="${param.name}"></sql:param>
<sql:param value="${param.salary}"></sql:param>
</sql:update>
</c:when>
<c:otherwise>
<font color="#cc0000"> Please enter mandatory information.</font>
</c:otherwise>
</c:choose>

<sql:query dataSource="${java}" var="emp">select * from employee</sql:query>
<table border="1">
<c:forEach var="row" items="${emp.rows}">

<tr> <td> <c:out value="${row.emp_id }"/></td>
 <td> <c:out value="${row.emp_name }"/></td> 
<td> <c:out value="${row.salary }"/></td> </tr>
</c:forEach>
</table>
</body>
</html>