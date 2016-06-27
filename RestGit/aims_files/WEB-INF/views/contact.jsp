<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>

<head>
  <title>Alumni Association</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <spring:url value="/resources/style/style.css" var="mainCss" /><spring:url value="/resources/js/datetimepicker_css.js" var="mainJs" /><link href="${mainCss}" rel="stylesheet" /><script src="${mainJs}"></script>
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
          <li><a href="gallary">Gallery</a></li>
          <li class="selected"><a href="#">Contact Us</a></li>
        </ul>
      </div>
    </div>
    <div id="content_header"></div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
    <font size="3"><br><br><br><br> <Address>3rd Floor, RMZ Westend Centre 3<br>
		D.P. Road, Aundh<br>
		Pune 411007<br>
        Email id: abc@gmail.com<br>
        Phone no.: 7387777727</Address></font>
		<p><br /><br />NOTE: For any queries <a href="mailto:webmaster@example.com">mail us</a>.<br> </p>
      </div>
      <div id="content">
        <!-- insert the page content here -->
		 <h1>Contact Us</h1>
		<iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0"width="500" height="440" src="https://maps.google.com/maps?hl=en&q=Cdac Acts Aundh pune&ie=UTF8&t=roadmap&z=15&iwloc=B&output=embed"></iframe>
		
        
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
    </div>
  </div>
</body>
</html>
