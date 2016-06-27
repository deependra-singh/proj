<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
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
						href="${pageContext.request.contextPath}/admin/admin_dashboard">DashBoard</a></li>


					<li class="selected"><a
						href="${pageContext.request.contextPath}/admin/admin_profile">Profile</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_approvals">Approvals</a></li>
					<li><a
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
			<div class="sidebar"></div>
			<div id="content">
				<!-- insert the page content here -->
				<h1>Update Profile</h1>

				<form:form action="admin_profile_edit1"
					modelAttribute="adminModel" method="post">

					<div class="form_settings">
						<p>
							<span>Employee Code</span><input class="contact" type="text"
								name="adminEmpCode" required="required"
								pattern="[a-zA-Z0-9-]*" title="Only charcters input"
								value="${valid_admin.adminEmpCode}" />
						</p>
						<p>
							<span>Designation</span><input class="contact" type="text"
								required="required" pattern="[a-zA-Z ,.-]*"
								title="Only charcters input" name="adminDesignation"
								value="${valid_admin.adminDesignation}" />
						</p>

						<p>


							<span>Year of appointment</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('ONDATE')" style="cursor: pointer">
							<input name="adminYearOfAppointment" id="ONDATE" size="20"
								style="width: 150px;" required="required"
								title="Only charcters input" type="text" readonly="readonly"
								value="<fmt:formatDate value="${valid_admin.adminYearOfAppointment}"
								pattern="dd-MM-yyyy" />"
								class="form-control" id="usr">

						</p>
						<p>

							<span>Year of release</span><img
								src="${pageContext.request.contextPath}/resources/images/cal.gif"
								onclick="javascript:NewCssCal('ONDATE')" style="cursor: pointer">
							<input name="adminYearOfRelease" id="ONDATE" size="20"
								style="width: 150px;" required="required"
								title="Only charcters input" type="text" readonly="readonly"
								value="<fmt:formatDate value="${valid_admin.adminYearOfRelease}"
								pattern="dd-MM-yyyy" />"
								class="form-control" id="usr">


						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="update" value="Update" />
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
