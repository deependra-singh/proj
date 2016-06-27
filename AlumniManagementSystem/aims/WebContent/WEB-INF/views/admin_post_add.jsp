<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<title>Add Post</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<spring:url value="/resources/style/style.css" var="mainCss" />
<spring:url value="/resources/js/datetimepicker_css.js" var="mainJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<script src="js/datetimepicker_css.js"></script>
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

					<li><a
						href="${pageContext.request.contextPath}/admin/admin_profile">Profile</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_approvals">Approvals</a></li>
					<li class="selected"><a
						href="${pageContext.request.contextPath}/admin/admin_post">Manage</a></li>
					<li><a
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

			<div id="content">
				<!-- insert the page content here -->
				<h1>Add Post</h1>
				<form:form action="admin_post_add" modelAttribute="postModel"
					method="post">
					<div class="form_settings">
						<p>
							<span>Message</span>
							<textarea required="required" title="Only charcters input"
								class="contact textarea" rows="5" cols="50" name="postMessage"></textarea>
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit" name="Add"
								value="Add" />
						</p>
					</div>
				</form:form>

			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
