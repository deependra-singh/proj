<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
    prefix="spring" uri="http://www.springframework.org/tags"%>
    <!DOCTYPE HTML>
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
                            <li><a href="contact">Contact Us</a></li>
                        </ul>
                    </div>
                </div>
                <div id="content_header"></div>
                <div id="site_content">
                    <div class="sidebar">
                        <!-- insert your sidebar items here -->
                    </div>
                    <div id="content">
                        <!-- insert the page content here -->
                        <h1>Registration</h1>
                        <p>Alumni information</p>

                        <form:form action="registerAlumniInfo" modelAttribute="alumniModel"
                                   method="post">

                            <div class="form_settings">


                                <p>
                                    <span>Roll No.</span><input class="contact" type="text"
                                                               name="alumniRoll" required="required" pattern="[a-zA-Z0-9-]*"
                                                               title="Enter number, character only" value="" />
                                </p>
                                <p>
                                    <span>Alumni Course</span><input class="contact" type="text"
                                                                     name="alumniCourse" required="required" pattern="[a-zA-Z0-9 ,.]*"
                                                                     title="Only charcters input" value="" />
                                </p>
                                <p>
                                    <span>Year of joining</span><img src="${pageContext.request.contextPath}/resources/images/cal.gif"
                                                                     onclick="javascript:NewCssCal('yearOfJoining')"
                                                                     style="cursor: pointer"> <input name="yearOfJoining"
                                                                     id="yearOfJoining" size="20" readonly
                                                                     style="width: 150px;" required="required"
                                                                     title="Only charcters input" type="text" class="form-control"
                                                                     id="usr">
                                </p>
                                <p>
                                    <span>Year of passing</span><img src="${pageContext.request.contextPath}/resources/images/cal.gif"
                                                                     onclick="javascript:NewCssCal('yearOfPassing')"
                                                                     style="cursor: pointer"> <input name="yearOfPassing"
                                                                     id="yearOfPassing" size="20" readonly
                                                                     style="width: 150px;" required="required"
                                                                     title="Only charcters input" type="text" class="form-control"
                                                                     id="usr">
                                </p>

                                <p style="padding-top: 15px">
                                    <span>&nbsp;</span><input class="submit" type="submit"
                                                              name="register1" value="Register" />
                                </p>
                            </div>
                        </form:form>
                        <p>
                            <br /> <br />NOTE: You will get confirmaion mail from admin
                            within 48 hours
                        </p>
                    </div>
                </div>
                <div id="content_footer"></div>
                <div id="footer"></div>
            </div>
        </body>
    </html>
