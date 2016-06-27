<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
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
                    <p><b>User Information</b></p>

                    <form:form action="registerUserInfo" modelAttribute="userModel" method="post">

                        <div class="form_settings">
                            <p>
                                <span>First Name</span><input class="contact" type="text"
                                                              required="required" pattern="[a-zA-Z]*"
                                                              title="Only charcters input" name="userFname" value="" />
                            </p>
                            <p>
                                <span>Last Name</span><input class="contact" type="text"
                                                             required="required" pattern="[a-zA-Z]*"
                                                             title="Only charcters input" name="userLname" value="" />
                            </p>
                            <p>
                                <span>Email Address</span><input class="contact" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" 
                                                                 required="required" name="userEmail" value="" />
                            </p>
                            <p>
                                <span>Password</span><input class="contact" type="password"
                                                            required="required" pattern="[a-zA-Z0-9@_]*"
                                                            title="Only charcters input" name="userPassword" value="" />
                            </p>
                            
                            
                            <p>
                                <span>Date Of Birth</span><img src="${pageContext.request.contextPath}/resources/images/cal.gif"
                                                               onclick="javascript:NewCssCal('ONDATE')" style="cursor: pointer">
                                <input name="userDob"  id="ONDATE" size="20"
                                       style="width: 150px;" required="required" readonly
                                       title="Enter DOB" type="text" class="form-control"
                                       id="usr">
                            </p>
                            <p>
                                <span>Address</span>
                                <textarea class="contact textarea" rows="5" cols="50"
                                          required="required" pattern="[a-zA-Z0-9 ,.]*"
                                          title="Only charcters, numbers , . , " name="userAddr"></textarea>
                            </p>
                            <p>
                                <span>City</span><input class="contact" type="text"
                                                        required="required" pattern="[a-zA-Z ]*"
                                                        title="Only charcters input" name="userCity" value="" />
                            </p>
                            <p>
                                <span>State</span><input class="contact" type="text"
                                                         required="required" pattern="[a-zA-Z]*"
                                                         title="Only charcters input" name="userState" value="" />
                            </p>
                            <p>
                                <span>Country</span><input class="contact" type="text"
                                                           required="required" pattern="[a-z A-Z]*"
                                                           title="Only charcters input" name="userCountry" value="" />
                            </p>


                            <p>
                                <span>Login Type</span><select name="loginType"
                                                               style="width: 400px;" class="form-control" id="sel2">
                                    <option value="">Please Select...</option>

                                    <option value="Admin">Admin</option>
                                    
                                    <option value="Alumni">Alumni</option>
                                    

                                </select>
                            </p>

                            <p>
                                <span>Contact No.</span><input class="contact" type="text"
                                                               required="required" pattern="[0-9]{10}" title="Enter 10 digit number"
                                                               name="userMobile" value="" />
                            </p>
                           
                            <p style="padding-top: 15px">
                                <span>&nbsp;</span><input class="submit" type="submit"
                                                          name="register" value="Next" />
                            </p>
                        </div>
                    </form:form>
                    <p>
                        
                    </p>
                </div>
            </div>
            <div id="content_footer"></div>
            <div id="footer"></div>
        </div>
    </body>
</html>
