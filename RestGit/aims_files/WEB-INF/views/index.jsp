<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html >
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
<script>
var status="<%=request.getParameter("status")%>";
	if (status != "null") {
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
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li class="selected"><a href="#">Home</a></li>
					<li><a href="gallary">Gallery</a></li>
					<li><a href="contact">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="site_content">
			<div class="sidebar">
				<!-- insert your sidebar items here -->

				<!-- insert the page content here -->
				<h1>Login</h1>
				<form:form action="${pageContext.request.contextPath}/user/login"
					modelAttribute="loginModel" method="post">
					<div class="form_settings1">
						<p>
							<span>Username</span><input class="contact" type="email"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="required" name="userEmail" value="" />
						</p>
						<p>
							<span>Password</span><input class="contact" type="password"
								required="required" pattern="[a-zA-Z0-9@_]*"
								title="Only charcters input" name="userPassword" value="" />
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="login" value="Login" /><input class="submit" type="reset"
								name="reset" value="Reset" />
						</p>
					</div>
				</form:form>
				<p>
					<a href="forgotpassword">Forgot Password</a> &nbsp;<a
						href="${pageContext.request.contextPath}/user/registerUserInfo">Click
						To Register</a>
				</p>
			</div>
			<div id="content">
			

				<h1>Welcome to CDAC Alumni Association</h1>
				<p>CDAC Alumni Association is a platform based on alumni
					networks. You can connect and leverage all your alumni networks on
					CDAC Alumni Association. It aims at bridging the alumni interaction
					gap and creating a strong network based on TRUST.</p>
				<p>CDAC Alumni Association focused on helping an alum / student
					get trusted help from his/her alumni network. Help ranging from
					getting referral for jobs, advice for careers and more.</p>

				<h2>About Us</h2>
				<p>Centre for Development of Advanced Computing (C-DAC) is the
					premier R&D organization of the Department of Electronics and
					Information Technology (DeitY), Ministry of Communications &
					Information Technology (MCIT) for carrying out R&D in IT,
					Electronics and associated areas. Different areas of C-DAC, had
					originated at different times, many of which came out as a result
					of identification of opportunities.</p>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
