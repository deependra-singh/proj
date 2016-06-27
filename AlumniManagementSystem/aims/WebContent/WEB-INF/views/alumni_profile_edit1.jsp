<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>

<head>
<title>Edit Profile</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />

<spring:url value="/resources/style/style.css" var="mainCss" />
<spring:url value="/resources/js/datetimepicker_css.js" var="mainJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>

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
						href="${pageContext.request.contextPath}/alumni/alumni_dashboard">DashBoard</a></li>
					<li class="selected"><a
						href="${pageContext.request.contextPath}/alumni/alumni_profile">Profile</a></li>

					<li><a
						href="${pageContext.request.contextPath}/alumni/alumni_post">Manage</a></li>
					<li><a
						href="${pageContext.request.contextPath}/alumni/alumni_gallary">Gallery</a></li>
					<li><a
						href="${pageContext.request.contextPath}/alumni/alumni_contact">Contact
							Us</a></li>
					<li><a
						href="${pageContext.request.contextPath}/alumni/alumni_logout">Logout</a></li>

				</ul>
			</div>
		</div>
		<div id="content_header"></div>
		<div id="site_content">
			<div class="sidebar"></div>
			<div id="content">
				<!-- insert the page content here -->
				<h1>Update profile</h1>


				<form:form action="alumni_profile_edit1"
					modelAttribute="alumniModel" method="post">

					<div class="form_settings">


						<p>
							<span>Roll No.</span><input class="contact" type="text"
								name="alumniRoll" required="required" pattern="[a-zA-Z0-9-]*"
								title="Enter Numbers, characters" value="${valid_user.alumniRoll}" />
						</p>
						<p>
							<span>Alumni Course</span><input class="contact" type="text"
								name="alumniCourse" required="required"
								pattern="[a-zA-Z0-9,.- ]*" title="Only charcters input"
								value="${valid_user.alumniCourse}" />
						</p>
						<p>

							<span>Year of joining</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('ONDATE')" style="cursor: pointer">
							<input name="yearOfJoining" id="ONDATE" size="20"
								style="width: 150px;" required="required"
								title="Select Date" type="text" readonly="readonly"
								value="<fmt:formatDate value="${valid_user.yearOfJoining}"
								pattern="dd-MM-yyyy" />"
								class="form-control" id="usr">

						</p>
						<p>
							<span>Year of passing</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('ONDATE')" style="cursor: pointer">
							<input name="yearOfPassing" id="ONDATE" size="20"
								style="width: 150px;" required="required"
								title="Select Date" type="text" readonly="readonly"
								value="<fmt:formatDate value="${valid_user.yearOfPassing}"
								pattern="dd-MM-yyyy" />"
								class="form-control" id="usr">

						</p>

						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="register1" value="Update" />
						</p>
					</div>
				</form:form>
				<p></p>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
