<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="learn" uri="/learn-tag2" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
String[] names = {"张三","李四", "王五"};
request.setAttribute("names", names);
%>

<learn:IterationTagDemo items="${names}" name="name">
${name}<BR>
</learn:IterationTagDemo>

</body>
</html>