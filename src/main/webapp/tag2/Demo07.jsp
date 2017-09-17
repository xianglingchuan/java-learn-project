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
pageContext.setAttribute("score", 100);

%>


<learn:Choose>
   <learn:When test="${score==99}">
   非常优秀!
   </learn:When>
   
   <learn:OtherWise>
   还需努力!
   </learn:OtherWise>

</learn:Choose>






</body>
</html>