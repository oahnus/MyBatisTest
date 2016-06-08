<%--
  Created by IntelliJ IDEA.
  User: jackstrom
  Date: 2016/5/19
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:out value='welcome'></c:out>
  <br>
  <% request.setAttribute("name","Jack"); %>
  <c:out value="${name}"></c:out>
  <br>
  <c:set var="day" scope="page">today</c:set>
  <c:out value="${day}"></c:out>
  <c:import url="http://www.baidu.com"></c:import>
  </body>
</html>
