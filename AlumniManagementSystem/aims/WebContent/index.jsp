<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%
    String redirectURL = request.getContextPath() + "/user/index";
    response.sendRedirect(redirectURL);
%>