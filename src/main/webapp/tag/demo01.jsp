<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="learn" uri="/learn-tag" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
%>
当前时间：<%=currentDate %><br><br><br>

自定义标签当前时间:<learn:DateTag/>


</body>
</html>