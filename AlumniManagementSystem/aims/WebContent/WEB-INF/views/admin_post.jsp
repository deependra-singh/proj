<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<html>

<head>
<title>Post</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<spring:url value="/resources/style/style.css" var="mainCss" />
<spring:url value="/resources/js/datetimepicker_css.js" var="mainJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<script>
var status='<%=request.getParameter("status")%>';

	if (status == "Event Added Successfully") {
		alert(status);
	} else if (status == "Event Updated Successfully") {
		alert(status);
	} else if (status == "Vacancy Updated Successfully") {
		alert(status);
	} else if (status == "Post Added Successfully") {
		alert(status);
	} else if (status == "Vacancy Added Successfully") {
		alert(status);
	}else if (status == "Post Add Failed") {
		alert(status);
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
			<div class="sidebar">
				<h4>
					<a href="admin_vacancies_add">Add Vacancies</a>
				</h4>
				<br />
				<h4>
					<a href="admin_post_add">Add Posts</a>
				</h4>
				<br />
				<h4>
					<a href="admin_event_add">Add Events</a>
				</h4>
				<br />
				<hr />
				<h1>My Events</h1>
				<div>
					<c1:forEach items="${userEvents_detail}" var="event">
						<p>
							<b>Event Name :</b> ${event.eventName} &nbsp; <b>Date :</b>
							${event.eventDate}<br /> <b>Description :</b>
							${event.eventDescription} <br /> <b>Venue :</b>
							${event.eventVenue} <a
								href="<spring:url value='admin_event_edit/${event.eventId}'/>">Edit
								Event</a>
						</p>
						<hr />
					</c1:forEach>
				</div>

			</div>
			<div id="content">
				<h4>
					<c1:if test="${loggedInUserInfo ne null}">${loggedInUserInfo.userFname}&nbsp;${loggedInUserInfo.userLname} logged in as ${loggedInUserInfo.loginType} </c1:if>

				</h4>
				<!-- insert the page content here -->
				<h1>My Posts</h1>
				<div>
					<c1:forEach var="postdata" items="${userposts_detail}">
						<p>${postdata.postMessage}</p>
						<p>
							<b>${postdata.postFromName}</b> &nbsp; &nbsp; &nbsp;<i>${postdata.postSendDate}</i>

						</p>
						<hr>
					</c1:forEach>
				</div>
				<h1>My Vacancies</h1>
				<div>
					<c1:forEach items="${userVacancies_detail}" var="vacancy">
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
								href="<spring:url value='admin_vacancies_edit/${vacancy.vacancyId}'/>">Edit
								Vacancy</a>
						</p>

						<hr />
					</c1:forEach>
				</div>


			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
