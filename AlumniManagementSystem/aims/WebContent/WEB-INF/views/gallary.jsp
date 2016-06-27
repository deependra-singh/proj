<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
  <title>Gallery</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
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
          <li><a href="index">Home</a></li>
          <li class="selected"><a href="#">Gallery</a></li>
          <li><a href="contact">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">

      <div id="content">
        <!-- insert the page content here -->
        <h1>Gallery</h1>
        
		<img src="${pageContext.request.contextPath}/resources/images/alumni1.jpg" height="300px" width="500px">
        <p>Convocation Event 2015</p>
		<img src="${pageContext.request.contextPath}/resources/images/alumni3.jpg" height="300px" width="500px">
        <p>Mr. Kapil Sibal at convocation Event 2016</p>
		<img src="${pageContext.request.contextPath}/resources/images/alumni4.jpg" height="300px" width="500px">
        <p>Welcoming New Students batch 2016</p>
		<img src="${pageContext.request.contextPath}/resources/images/alumni6.jpg" height="300px" width="500px">
        <p>Hon'ble PM Mr.Narendra Modi Visiting PARAM Super Computer </p>
		<img src="${pageContext.request.contextPath}/resources/images/alumni2.gif" height="300px" width="500px">
        <p>CDAC ACTS Building</p>
       
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
    </div>
  </div>
</body>
</html>
