<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<head>
<title>Edit Event</title>
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
				<h1>Update Event</h1>

				<form:form modelAttribute="eventModel" method="post">

					<div class="form_settings">
						<p>
							<span>Event Name</span><input class="contact" required="required"
								pattern="[a-zA-Z0-9 -,.]*" title="Only characters, numbers, .-"
								type="text" name="eventName" value="${eventModel.eventName}" />
						</p>
						<p>


							<span>Description</span>
							<textarea rows="*" cols="*" required="required"
								pattern="[a-zA-Z0-9 ,.-]*" title="Only charcters, numbers,.-"
								name="eventDescription">${eventModel.eventDescription}</textarea>

						</p>
						<p>

							<span>Venue</span>
							<textarea rows="*" cols="*" required="required"
								pattern="[a-zA-Z0-9 ,.-]*" title="Only charcters, numbers"
								name="eventVenue">${eventModel.eventVenue}</textarea>

						</p>
						<p>

							<span>Event Date</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('ONDATE')" style="cursor: pointer">
							<input name="eventDate" id="ONDATE" size="20"
								style="width: 150px;" required="required"
								title="Only charcters input" type="text" readonly="readonly"
								value="<fmt:formatDate value="${eventModel.eventDate}"
								pattern="dd-MM-yyyy" />"
								class="form-control" id="usr">

						</p>

						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit" name="Add"
								value="Update" />
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
