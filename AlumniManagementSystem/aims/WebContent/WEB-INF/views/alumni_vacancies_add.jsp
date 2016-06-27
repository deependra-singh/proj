<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<title>Add Vacancy</title>
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
						href="${pageContext.request.contextPath}/alumni/alumni_dashboard">DashBoard</a></li>
					<li><a
						href="${pageContext.request.contextPath}/alumni/alumni_profile">Profile</a></li>

					<li class="selected"><a
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

			<div id="content">
				<!-- insert the page content here -->
				<h1>Add Vacancy</h1>

				<form:form action="alumni_vacancies_add"
					modelAttribute="vacancyModel" method="post">
					<div class="form_settings">
						<p>
							<span>Company Name</span><input class="contact"
								required="required" pattern="[a-zA-Z0-9,.- ]*"
								title="Only charcters input" type="text" name="vacancyCompany"
								value="" />
						</p>
						<p>
							<span>Position</span><input class="contact" type="text"
								required="required" pattern="[a-zA-Z,. - 0-9]*"
								title="Only charcters input" name="vacancyPosition" value="" />
						</p>
						<p>
							<span>Category</span><input class="contact" type="text"
								required="required" pattern="[a-zA-Z,.- 0-9]*"
								title="Only charcters input" name="vacancyCategory" value="" />
						</p>
						<p>
							<span>Description</span>
							<textarea required="required" pattern="[a-zA-Z,. -0-9]*"
								title="Only charcters input" class="contact textarea" rows="5"
								cols="50" name="vacancyDescription"></textarea>
						</p>
						<p>
							<span>Requirements</span>
							<textarea class="contact textarea" required="required"
								pattern="[a-z,.- A-Z0-9]*" title="Only charcters input" rows="5"
								cols="50" name="vacancyRequirements"></textarea>
						</p>
						<p>
							<span>Location</span><input class="contact" type="text"
								required="required" pattern="[a-z,.- A-Z0-9]*"
								title="Only charcters input" name="vacancyLocation" value="" />
						</p>
						<p>
							<span>Experience Required</span><input class="contact"
								required="required" pattern="[a-zA-Z0-9,.- ]*"
								title="Only charcters input" type="text" name="vacancyReqexp"
								value="" />
						</p>
						<p>
							<span>Expiry Date</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('expdate')"
								style="cursor: pointer"> <input name="vacancyExpiryDate"
								readonly="readonly" id="expdate" size="20" style="width: 150px;"
								required="required" title="Only charcters input" type="text"
								class="form-control" id="usr">
						</p>
						<p>
							<span>Contact Person</span><input class="contact"
								required="required" pattern="[a-zA-Z0-9,.- ]*"
								title="Only charcters input" type="text" name="vacancyContact"
								value="" />
						</p>
						<p>
							<span>Designation</span><input class="contact" type="text"
								pattern="[a-zA-Z0-9,.- ]*" name="vacancyDesignation" value="" />
						</p>
						<p>
							<span>Email</span><input class="contact" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
								required="required" name="vacancyEmail" value="" />
						</p>
						<p>
							<span>Phone</span><input class="contact" type="text"
								required="required" pattern="[0-9]{10}" title="Enter 10 digits"
								name="vacancyPhone" value="" />
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
