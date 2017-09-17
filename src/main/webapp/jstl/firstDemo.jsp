
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:useBean id="person" class="com.myspringmvc.jstl.bean.Person"></jsp:useBean>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>out标签</h1>
<!-- 使用out标签输出常量 -->
<c:out value="this is JSTL first demo"></c:out><BR><BR>

<!-- 使用out标签输出变量 -->
输出username:<c:out value="${username1}"></c:out>end<BR><BR>

判断字符串是否为空：
<%String name = null; request.setAttribute("name", name); %>
<c:out value="${empty name}"></c:out><BR><BR>

<!-- 当变量不存在时，用default标签设置默认值 -->
<c:out value="${name1}" default="暂无该变量值"></c:out><BR><BR>

<!-- 设置输出转义后的字符需要escapeXml属性值设备成falsh -->
<c:out value="&ltout标签&gt" escapeXml="false"></c:out><BR><BR>

<h1>set标签</h1>
<!-- 存值到scope中 -->
<c:set value="today" var="day" scope="session"> </c:set>
<c:out value="${day}"></c:out><BR><BR>

<c:set var="age" scope="application">eleven</c:set>
<c:out value="${age}"></c:out><BR><BR>



<!-- 通过set标签向person中赋值 -->
pname:<c:set target="${person}" property="pname" value="李明"></c:set>
<c:out value="${person.pname}"></c:out>&nbsp;&nbsp;
page:<c:set target="${person}" property="page" value="22"></c:set>
<c:out value="${person.page}"></c:out>&nbsp;&nbsp;
paddress:<c:set target="${person}" property="paddress" value="深圳市 南山区"></c:set>
<c:out value="${person.paddress}"></c:out>&nbsp;&nbsp;<BR><BR>

pname:<c:set target="${person}" property="pname">韩梅梅</c:set>
<c:out value="${person.pname}"></c:out>&nbsp;&nbsp;
page:<c:set target="${person}" property="page">22</c:set>
<c:out value="${person.page}"></c:out>&nbsp;&nbsp;
paddress:<c:set target="${person}" property="paddress">深圳市 南山区</c:set>
<c:out value="${person.paddress}"></c:out>&nbsp;&nbsp;


<h1>remove标签</h1>
<c:set value="刘文强" var="fristName"></c:set>
<c:out value="${fristName}"></c:out>

<c:set value="刘菲菲" var="lastName"></c:set>
<c:remove var="lastName"/>
<c:out value="${lastName}"></c:out>

<h1>catch标签</h1>

<c:catch var="error">
   <c:set target="userTmp" property="tmpName">王丽</c:set>
</c:catch>
<c:out value="${error }"></c:out>


<h1>if标签</h1>
<form action="./firstDemo.jsp" method="post">
   <input type="text" name="score" value="${param.score}">
   <input type="submit" value="查询">
</form>

<%-- <c:if test="${param.score>=90}" var="result">
   <c:out value="你的成绩为优秀!"></c:out>
</c:if>
<c:if test="${param.score>=80 && param.score<=89}" var="result">
   <c:out value="你的成绩为良好!"></c:out>
</c:if>
<c:if test="${param.score>=70 && param.score<=79}" var="result">
   <c:out value="你的成绩为中等!"></c:out>
</c:if>
<c:if test="${param.score>=60 && param.score<=69}" var="result">
   <c:out value="你的成绩为及格!"></c:out>
</c:if>
<c:if test="${param.score<=59}" var="result">
   <c:out value="你的成绩为不及格!"></c:out>
</c:if> 
<c:out value="${result }"></c:out>
--%>

<h1>choose-when-otherwsie标签</h1>
<c:choose>
   <c:when test="${param.score>=90 && param.score<=100}">
     <c:out value="你的成绩是优秀!"></c:out>
   </c:when>
   <c:when test="${param.score>=80 && param.score<=89}">
     <c:out value="你的成绩为良好!"></c:out>
   </c:when>   
   <c:when test="${param.score>=70 && param.score<=79}">
     <c:out value="你的成绩为中等!"></c:out>
   </c:when>   
   <c:when test="${param.score>=60 && param.score<=69}">
     <c:out value="你的成绩为及格!"></c:out>
   </c:when>  
   <c:when test="${param.score>=0 && param.score<=59}">
     <c:out value="你的成绩为不及格!"></c:out>
   </c:when>   
   <c:otherwise>
     <c:out value="你的输入不合法!"></c:out>
   </c:otherwise>  
</c:choose>
<BR><BR>

<c:choose>
  <c:when test="${param.score==100 }">
    <c:out value="你是第一名"></c:out>
  </c:when>
</c:choose>

<h1>forEach标签</h1>
<%
List<String> fruits = new ArrayList<String>();
fruits.add("apple");
fruits.add("orange");
fruits.add("pear");
fruits.add("watermelon");
fruits.add("banana");
fruits.add("grape");
request.setAttribute("fruits", fruits);
%>
<c:forEach items="${fruits}" var="fruit">
  <c:out value="${fruit}"></c:out><BR>
</c:forEach>
<c:out value="===================="></c:out>
<BR><BR>

<!-- 部分遍历 -->
<c:forEach items="${fruits}" var="fruit" begin="1" end="3">
  <c:out value="${fruit}"></c:out><BR>
</c:forEach>
<c:out value="===================="></c:out>
<BR><BR>

<!-- 指定循环步长 -->
<c:forEach items="${fruits}" var="fruit" step="2">
  <c:out value="${fruit}"></c:out><BR>
</c:forEach>
<c:out value="===================="></c:out>
<BR><BR>

<!-- 循环元素的状态值 -->
<c:forEach items="${fruits}" var="fruit" varStatus="status">
  <c:out value="${fruit}"></c:out><BR>
  Index:<c:out value="${status.index}"></c:out><BR>
  count:<c:out value="${status.count}"></c:out><BR>
  first:<c:out value="${status.first}"></c:out><BR>
  last:<c:out value="${status.last}"></c:out><BR>
  <c:out value="--------------"></c:out><BR>
</c:forEach>
<c:out value="===================="></c:out><BR><BR>




<h1>forTokens标签</h1>
<c:forTokens items="010-12345678-321" delims="-" var="number">
  <c:out value="${number}"></c:out><BR>
</c:forTokens>
<c:out value="===================="></c:out><BR><BR>

<c:out value="010-12345678-321-456-789"></c:out><BR><BR>
<c:forTokens items="010-12345678-321-456-789" delims="-" var="number" begin="1" end="4">
  <c:out value="${number}"></c:out><BR>
</c:forTokens>
<c:out value="===================="></c:out><BR><BR>


<c:forTokens items="010-12345678-321-456-789" delims="-" var="number" step="2">
  <c:out value="${number}"></c:out><BR>
</c:forTokens>
<c:out value="===================="></c:out><BR><BR>

<c:forTokens items="010-12345678-321-456-789" delims="-" var="number" varStatus="status">
  <c:out value="${number}"></c:out><BR>
  Index:<c:out value="${status.index}"></c:out><BR>
  count:<c:out value="${status.count}"></c:out><BR>
  first:<c:out value="${status.first}"></c:out><BR>
  last:<c:out value="${status.last}"></c:out><BR>
  <c:out value="-------------------"></c:out><BR><BR>
</c:forTokens>
<c:out value="===================="></c:out><BR><BR>


<h1>import标签</h1>
<c:catch var="error1">
   <c:import url="http://www.baidu.com" charEncoding="utf-8"></c:import>
</c:catch>
<c:out value="${error1}"></c:out>
<BR><BR>


<c:catch var="error2">
   <c:import url="tt.txt" charEncoding="utf-8"></c:import>
</c:catch>
<c:out value="${error2}"></c:out>
<BR><BR>


<!-- var和scope用法 -->
<c:catch var="error3">
   <c:import url="tt.txt" charEncoding="utf-8" var="myName" scope="session"></c:import>
</c:catch>
<c:out value="${error3}"></c:out>
<c:out value="import标签存储的tt字符串变量为：${sessionScope.myName}"></c:out>

<!-- context属性用法 -->
<c:catch var="error4">
   <c:import url="/importFile.jsp" context="/myTest" charEncoding="utf-8" ></c:import>
</c:catch>
<c:out value="${error4}"></c:out>




<h1>redirect标签</h1>
username:<c:out value="${param.username }"></c:out><BR>
password:<c:out value="${param.password }"></c:out>

<h1>url标签</h1>
<c:url value="http://localhost:8080/mySpringmvc?username=${param.username }&password=${param.password }" var="newUrl" scope="session">
</c:url>
<a href="${newUrl}">新的URL</a>







</body>
</html>