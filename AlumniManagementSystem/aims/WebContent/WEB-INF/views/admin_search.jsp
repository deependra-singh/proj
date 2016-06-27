<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Search</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<spring:url value="/resources/style/style.css" var="mainCss" />
<spring:url value="/resources/js/datetimepicker_css.js" var="mainJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<script src="js/datetimepicker_css.js"></script>

<script>
var status='<%=request.getParameter("status")%>';

	if (status == "Matching data found") {
		alert(status);
	} else if (status == "No matching data found") {
		alert(message);
	}
</script>
</head>

<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->

				</div>
			</div>
			<div id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_dashboard">DashBoard</a></li>

					<li ><a
						href="${pageContext.request.contextPath}/admin/admin_profile">Profile</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_approvals">Approvals</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_post">Manage</a></li>
					<li class="selected"><a
						href="${pageContext.request.contextPath}/admin/admin_search">Search</a></li>

					<li><a
						href="${pageContext.request.contextPath}/admin/admin_gallary">Gallery</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_contact">Contact
							Us</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_logout">Logout</a></li>
				</ul>
			</div>
		</div>
		<div id="content_header"></div>
		<div id="site_content">
			<div class="sidebar">
				<!-- insert your sidebar items here -->

				<!-- insert the page content here -->



			</div>
			<div id="content">
				<!-- insert the page content here -->
				<h2>Search By Name</h2>
				<div>
					<form:form
						action="${pageContext.request.contextPath}/admin/admin_search"
						modelAttribute="userModel" method="post">
						<div class="form_settings1">

							<p>
								<span>First Name</span><input class="contact" type="text"
									name="userFname" value="" />
							</p>
							<p>
								<span>Last Name</span><input class="contact" type="text"
									pattern="[a-zA-Z]*" title="Only charcters input"
									name="userLname" value="" />
							</p>
							<p>
								<input class="submit" type="submit" name="alumni_search"
									value="Search" />
							</p>
						</div>
					</form:form>

					<div>
						<p>
							<font color="red">${requestScope.Status}</font>
						</p>
					</div>
					<div>
						<c:forEach items="${requestScope.search}" var="search">
							<a
								href="<spring:url value='alumni_profile_search/${search.userId}'/>"><b>${search.userFname}&nbsp;${search.userLname}</b></a>
							<br />
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
