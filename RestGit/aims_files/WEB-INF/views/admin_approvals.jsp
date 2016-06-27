<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Approvals</title>
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

	if (status == "Alumni Approved Successfully") {
		alert(status);
	} else if (status == "Alumni not approved") {
		alert(message);
	} else if (status == "Admin Approved Successfully") {
		alert(status);
	} else if (status == "Admin not approved") {
		alert(message);
	} else if (status == "Post Approved Successfully") {
		alert(status);
	} else if (status == "Post not approved") {
		alert(message);
	} else if (status == "Vacancy Approved Successfully") {
		alert(status);
	} else if (status == "Vacancy not approved") {
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
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_dashboard">DashBoard</a></li>

					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a
						href="${pageContext.request.contextPath}/admin/admin_profile">Profile</a></li>
					<li class="selected"><a
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
			<div class="sidebar">
				<!-- insert your sidebar items here -->

				<!-- insert the page content here -->



			</div>
			<div id="content">
				<h4>
					<c:if test="${loggedInUserInfo ne null}">${loggedInUserInfo.userFname}&nbsp;${loggedInUserInfo.userLname} logged in as ${loggedInUserInfo.loginType} </c:if>

				</h4>

				<h1>Registration Approval Requests</h1>

				<h3>Admin approval</h3>
				<div>
					<c:forEach items="${allAdmin_Unapproved}" var="approve">
						<p>
							<b>Name :</b> ${approve.userFname} &nbsp; ${approve.userLname}
							&nbsp; <b>DOB :</b> ${approve.userDob} &nbsp; <b> Designation
								:</b> ${approve.adminDesignation} &nbsp;<b> Appointment Date :</b>
							${approve.adminYearOfAppointment} &nbsp; <b> Release Date :</b>
							${approve.adminYearOfRelease}&nbsp;<b> Email :</b>
							${approve.userEmail} &nbsp; <b> Login Type :</b>
							${approve.loginType} &nbsp;<u><b><i> Approval </i></b></u>&nbsp;<a
								href="<spring:url value='admin_admin_approve/${approve.userId}'/>"><i>Yes</i>
							</a>&nbsp;<a
								href="<spring:url value='admin_admin_unapprove/${approve.userId}'/>"><i>No</i></a>
						</p>
						<hr />

					</c:forEach>
				</div>

				<h3>Alumni approval</h3>
				<div>
					<c:forEach items="${allAlumni_Unapproved}" var="approve">
						<p>
							<b>Name :</b> ${approve.userFname} &nbsp; ${approve.userLname}
							&nbsp; <b>DOB :</b> ${approve.userLname} &nbsp; <b> Course :</b>
							${approve.alumniCourse} &nbsp;<b> Joining Date :</b>
							${approve.yearOfJoining} &nbsp; <b> Passing Date :</b>
							${approve.yearOfPassing}&nbsp;<b> Email :</b>
							${approve.userEmail} &nbsp; <b> Login Type :</b>
							${approve.loginType} &nbsp;<u><b><i> Approval </i></b></u>&nbsp;<a
								href="<spring:url value='admin_approve/${approve.userId}'/>"><i>Yes</i>
							</a>&nbsp;<a
								href="<spring:url value='admin_unapprove/${approve.userId}'/>"><i>No</i></a>
						</p>
						<hr />

					</c:forEach>
				</div>



				<h1>Vacancies Approval Requests</h1>
				<div>
					<c:forEach items="${allVacancy_Unapproved}" var="vacancy">
						<p>
							<b>Posted Date :</b> ${vacancy.vacancyCreateDate} &nbsp; <b>
								Last Date To apply :</b> ${vacancy.vacancyExpiryDate}<br /> <b>
								Company :</b> ${vacancy.vacancyCompany} &nbsp;<b> Designation :</b>
							${vacancy.vacancyDesignation} <br /> <b> Position :</b>
							${vacancy.vacancyPosition}&nbsp;<b> Required Experience :</b>
							${vacancy.vacancyReqexp} &nbsp;<b> Required Requirements :</b>
							${vacancy.vacancyRequirements}<br /> <b> Description :</b>
							${vacancy.vacancyDescription} <br /> <b> Location :</b>
							${vacancy.vacancyLocation} <br /> <b> Contact Details :</b>
							${vacancy.vacancyContact} &nbsp;<b> Email :</b>
							${vacancy.vacancyEmail} <b>Phone :</b> ${vacancy.vacancyPhone}<br />

							<a
								href="<spring:url value='admin_vacancy_approve/${vacancy.vacancyId}'/>"><i>Yes</i>
							</a>&nbsp;<a
								href="<spring:url value='admin_vacancy_unapprove/${vacancy.vacancyId}'/>"><i>No</i></a>
						</p>

						<hr />
					</c:forEach>
				</div>


				<h1>Post Approval Requests</h1>
				<div>
					<c:forEach items="${allPost_Unapproved}" var="approve">
						<p>
							<b>Name :</b> ${approve.postFromName} &nbsp;<b> Send Date :</b>
							${approve.postSendDate} <br /> <b>Message :</b>
							${approve.postMessage} <br /> &nbsp; <b><i> Approval </i></b>&nbsp;<a
								href="<spring:url value='admin_post_approve/${approve.postId}'/>"><i>Yes</i>
							</a>&nbsp;<a
								href="<spring:url value='admin_post_unapprove/${approve.postId}'/>"><i>No</i></a>
						</p>
						<hr />

					</c:forEach>
				</div>

			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
