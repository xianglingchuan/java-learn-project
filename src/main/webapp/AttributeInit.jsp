<%@page import="com.myspringmvc.listener.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<%
request.setAttribute("requestName", "requestValue");
request.getSession().setAttribute("sessionName", "sessionValue");
request.getSession().getServletContext().setAttribute("contextName", "contextValue");

request.getSession().setAttribute("currentUser", new User());

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3><a href="./AttributeInit.jsp">Init Attribute</a></h3><BR>
<h3><a href="./AttributeDestroy.jsp">Destroy Attribute</a></h3><BR>


</body>
</html>