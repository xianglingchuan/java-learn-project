<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSTL函数的使用</h1>

<c:set value="Hello world, learn java" var="myStr"></c:set>

<c:out value="${myStr}中是否包含了Hello: ${fn:contains(myStr,'Hello')}"></c:out><BR><BR>
<c:out value="${myStr}中是否包含了aaaaaa: ${fn:contains(myStr,'aaaaaa')}"></c:out><BR><BR>
<c:out value="${myStr}中是否包含了hello: ${fn:containsIgnoreCase(myStr,'hello')}"></c:out><BR><BR>

<c:out value="${myStr}中开始位置是否为hello: ${fn:endsWith(myStr,'hello')}"></c:out><BR><BR>
<c:out value="${myStr}中结束位置是否为java: ${fn:startsWith(myStr,'java')}"></c:out><BR><BR>

<book>钢铁是怎么练成的</book>
<c:out value="${fn.escapeXml('<book>钢铁是怎么练成的</book>') }"></c:out><BR><BR>
<c:out value="${'<book>钢铁是怎么练成的</book>'}"></c:out><BR><BR>

<c:out value="${myStr}中'ell'出现的位置是: ${fn:indexOf(myStr,'ell')}"></c:out><BR><BR>

</body>
</html>