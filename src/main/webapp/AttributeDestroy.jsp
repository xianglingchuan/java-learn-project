<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.removeAttribute("requestName");
request.getSession().removeAttribute("sessionName");
request.getSession().getServletContext().removeAttribute("contextName");

//解除绑定
//request.getSession().setAttribute("currentUser", new User());
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