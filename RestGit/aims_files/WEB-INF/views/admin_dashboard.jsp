<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<html>

<head>
<title>Alumni Association</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />

<spring:url value="/resources/style/style.css" var="mainCss" />
<spring:url value="/resources/js/jquery-1.8.0.min.js" var="jqueryJs" />
<spring:url value="/resources/js/nicescroll.js" var="scrollJs" />
<link href="${mainCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>
<script src="${scrollJs}"></script>
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
					<li class="selected"><a
						href="${pageContext.request.contextPath}/admin/admin_dashboard">DashBoard</a></li>

					<li><a
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
		<div id="site_content" style="height: 440px;">
			<div class="sidebar">
				<h1>Events</h1>
				<div id="events" style="height: 310px; overflow: scroll;">
					<c1:forEach items="${allevents_detail}" var="event">
						<p>
							<b>Event Name :</b> ${event.eventName}<br /> <b>Date :</b>
							${event.eventDate}<br /> <b>Description :</b>
							${event.eventDescription}<br /> <b>Venue :</b>
							${event.eventVenue}
						</p>
						<hr />
					</c1:forEach>
				</div>
			</div>
			<div id="content">
				<div style="float: left; width: 265px; padding-right: 25px;">
					<!-- insert the page content here -->
					<h1>Posts</h1>
					<div id="post" style="height: 310px; overflow: scroll">
						<c1:forEach var="postdata" items="${allposts_detail}">
							<p>${postdata.postMessage}</p>
							<p>
								<b>${postdata.postFromName}</b> &nbsp; &nbsp; &nbsp;<i>${postdata.postSendDate}</i>
							<hr>
							</p>
						</c1:forEach>
					</div>
				</div>
				<div style="float: left; width: 290px;">
					<h1>Vacancies</h1>
					<div id="vacancy" style="height: 310px; overflow: scroll">
						<c1:forEach items="${allVacancies_detail}" var="vacancy">
							<p>
								<b>Posted Date :</b> ${vacancy.vacancyCreateDate}<br /> <b>Last
									Date To apply :</b> ${vacancy.vacancyExpiryDate}<br /> <b>Company
									:</b> ${vacancy.vacancyCompany}<br /> <b>Designation :</b>
								${vacancy.vacancyDesignation}<br /> <b>Position :</b>
								${vacancy.vacancyPosition}<br /> <b>Required Experience :</b>
								${vacancy.vacancyReqexp}<br /> <b>Required Requirements :</b>
								${vacancy.vacancyRequirements}<br /> <b>Description :</b>
								${vacancy.vacancyDescription}<br /> <b>Location :</b>
								${vacancy.vacancyLocation}<br /> <b>Contact Details :</b>
								${vacancy.vacancyContact}<br /> <b>Email :</b>
								${vacancy.vacancyEmail}<br /> <b>Phone :</b>
								${vacancy.vacancyPhone}
							</p>
							<hr />
						</c1:forEach>
					</div>
				</div>


			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#events").niceScroll({
				autohidemode : true
			})
		});

		$(document).ready(function() {
			$("#post").niceScroll({
				autohidemode : true
			})
		});

		$(document).ready(function() {
			$("#vacancy").niceScroll({
				autohidemode : true
			})
		});
	</script>
</body>
</html>
