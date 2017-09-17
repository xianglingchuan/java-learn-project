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
String password = "111111";
String username = "root";
String url = "jdbc:mysql://localhost:3306/learn";
String driver = "com.mysql.jdbc.Driver";
String sql = "select * from user";

pageContext.setAttribute("password", password);
pageContext.setAttribute("username", username);
pageContext.setAttribute("url", url);
pageContext.setAttribute("driver", driver);
pageContext.setAttribute("sql", sql);
%>


<learn:DbConnect password="${password}" 
url="${url}" 
driver="${driver}" 
sql="${sql}" 
username="${username}"/>


</body>
</html>