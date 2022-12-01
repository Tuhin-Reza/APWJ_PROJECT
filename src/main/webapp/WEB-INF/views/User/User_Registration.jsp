<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/20/2022
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form action="submit" modelAttribute="user">
  <label for="name">Name:</label>
  <form:input path="name" id="name"/>
  <form:errors path="name"/>
  <br><br>
  <label for="password">Password:</label>
  <form:input path="password" id="password"/>
  <form:errors path="password"/>
  <br><br>
  <input type="submit" value="Login">
</form:form>
</body>
</html>
