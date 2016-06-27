<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script>
var status='<%=request.getParameter("status")%>';

	if (status == "Profile Update Failed") {
		alert(status);
	} else if (status == "Profile Updated Successfully") {
		alert(status);
	}
</script>
</head>

<body>
	<c:choose>
		<c:when test="${loggedInUserInfo ne null}">
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
						<h4>
							<c:if test="${loggedInUserInfo ne null}">${loggedInUserInfo.userFname}&nbsp;${loggedInUserInfo.userLname} logged in as ${loggedInUserInfo.loginType} </c:if>
							(<a href="alumni_profile_userinfo_edit">Edit Profile</a>)
						</h4>
						<h1>Profile</h1>

						<form action="#" method="post">
							<div class="form_settings">
								<p>
									<span>First Name</span><input class="contact" type="text"
										readonly name="alumni_fname" value="${valid_user.userFname}" />
								</p>
								<p>
									<span>Last Name</span><input class="contact" type="text"
										readonly name="alumni_lname" value="${valid_user.userLname}" />
								</p>
								<p>
									<span>Email Address</span><input class="contact" type="text"
										readonly name="alumni_email" value="${valid_user.userEmail}" />
								</p>

								<p>
									<span>Date Of Birth</span>
									<fmt:formatDate var="alumni_dob" pattern="dd/MM/yyyy"
										value="${valid_user.userDob}" />

									<input class="contact" type="text" readonly name="alumni_dob"
										value="${alumni_dob}" />
								</p>


								<p>

									<span>Address</span>
									<textarea rows="*" cols="*" required="required"
										readonly="readonly" pattern="[a-zA-Z ,.-]*"
										title="Only charcters input" name="alumni_address">${valid_user.userAddr}</textarea>




								</p>
								<p>
									<span>City</span><input class="contact" type="text" readonly
										name="alumni_city" value="${valid_user.userCity}" />
								</p>
								<p>
									<span>State</span><input class="contact" type="text" readonly
										name="alumni_state" value="${valid_user.userState}" />
								</p>
								<p>
									<span>Country</span><input class="contact" type="text" readonly
										name="alumni_country" value="${valid_user.userCountry}" />
								</p>

								<p>
									<span>Roll No.</span><input class="contact" type="text"
										readonly name="alumni_roll" value="${valid_user.alumniRoll}" />
								</p>
								<p>
									<span>Alumni Course</span><input class="contact" type="text"
										readonly name="alumni_course"
										value="${valid_user.alumniCourse}" />
								</p>
								<p>
									<span>Year of joining</span>
									<fmt:formatDate var="yearOfJoining" pattern="dd/MM/yyyy"
										value="${valid_user.yearOfJoining}" />

									<input class="contact" type="text" readonly
										name="year_of_joining" value="${yearOfJoining}" />
								</p>

								<p>
									<span>Year of passing</span>
									<fmt:formatDate var="yearOfPassing" pattern="dd/MM/yyyy"
										value="${valid_user.yearOfPassing}" />

									<input class="contact" type="text" readonly
										name="year_of_passing" value="${yearOfPassing}" />
								</p>
								<p>
									<span>Contact No.</span><input class="contact" type="text"
										readonly name="alumni_mobile" value="${valid_user.userMobile}" />
								</p>

							</div>
						</form>

					</div>
				</div>
				<div id="content_footer"></div>
				<div id="footer"></div>
			</div>
		</c:when>
		<c:otherwise>
			<h1>
				<p>
					<span style="color: red"> Your Session has been expired
						.Please <a href="${pageContext.request.contextPath}/user/index">
							Click here to login</a>
					</span>
				</p>
			</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>
