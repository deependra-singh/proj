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

			<div id="content">
				<!-- insert the page content here -->
				<h1>Register</h1>
				<p><b>Admin information</b></p>
				
				<form:form action="registerAdminInfo"
					modelAttribute="adminModel" method="post">

					<div class="form_settings">
						<p>
							<span>Employee Code</span><input class="contact" type="text"
								name="adminEmpCode" required="required"
								pattern="[a-zA-Z0-9-]*" title="Enter number, character input" value="" />
						</p>
						<p>
							<span>Designation</span><input class="contact" type="text"
								required="required" pattern="[a-z .A-Z]*"
								title="Only charcters input" name="adminDesignation" value="" />
						</p>

						<p>
							<span>Year of appointment</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								required="required"
								onclick="javascript:NewCssCal('admin_year_of_appointment')"
								style="cursor: pointer"> <input
								name="adminYearOfAppointment" readonly="readonly"
								id="admin_year_of_appointment" size="20" style="width: 150px;"
								title="Select Date" type="text" class="form-control"
								id="usr">
						</p>
						<p>
							<span>Year of release</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('admin_year_of_release')"
								style="cursor: pointer"> <input
								name="adminYearOfRelease" readonly="readonly"
								id="admin_year_of_release" size="20" style="width: 150px;"
								 title="Select Date" type="text"
								class="form-control" id="usr">
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="register" value="Register" />
						</p>
					</div>
				</form:form>
				<p>
					<br /> <br />NOTE: You will get confirmaion mail from admin
					within 48 hours
				</p>

			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
