<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<title>Alumni Association</title>
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
					<li><a href="index">Home</a></li>
					<li><a href="gallary">Gallery</a></li>
					<li><a href="contact">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="content_header"></div>
		<div id="site_content">
			<div class="sidebar">
				<!-- insert your sidebar items here -->
				
			</div>
			<div id="content">
				<!-- insert the page content here -->
				<h1>Forgot Password</h1>
				<p>Please fill information below to get password</p>
				<form:form action="forgotpassword" modelAttribute="userModel"
					method="post">

					<div class="form_settings">
						<p>
							<span>Email Address</span><input class="contact" type="email"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="required" name="userEmail" value="" />
						</p>


						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="forgotuname" value="Submin" />
						</p>
					</div>
				</form:form>
				<p>
					<br />
					<br />NOTE: You will get confirmaion mail within 5 minuits
				</p>
			</div>
		</div>

	</div>
</body>
</html>
