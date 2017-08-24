<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.myspringmvc.listener.entity.OnlineUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


当前用户为:<%=request.getSession().getAttribute("currentUser") %>
<h3><a href="./AttributeInit.jsp">Init Attribute</a></h3><BR>
<h3><a href="./AttributeDestroy.jsp">Destroy Attribute</a></h3><BR>


当前在线用户数为:<%=request.getSession().getServletContext().getAttribute("userNumber") %>

当前在线用户人数:${userNumber}<br/>

<h1>当前在线用户列表：</h1>
   <% 
   ArrayList<OnlineUser>  users = (ArrayList<OnlineUser>)request.getServletContext().getAttribute("onlineUsers"); 
     
   if(users!=null){
	 for(int i = 0 ; i < users.size() ; i++){
	    OnlineUser user = users.get(i);  
%>      
       sessionID:<%=user.getSessionIdString() %><BR>
       访问时间:<%=user.getFirstTimeString() %><BR>
       访问IP:<%=user.getIpString() %> <BR>
       ----------------------------------------
       <BR><BR><BR>
<%     
   }
 }
%>



</body>
</html>