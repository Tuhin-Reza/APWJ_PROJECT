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
  <style type="text/css">
    .error {
      color: red;
    }
  </style>
    <title>Registration</title>
</head>
<body>

<table>
  <form:form action="submit" modelAttribute="user">
    <tr>
      <td>User:</td>
      <td>
        <form:input path="user_name" id="user_name"/><br>
        <form:errors path="user_name" cssClass="error"/>
      </td>
    </tr>

    <tr>
      <td>Password:</td>
      <td>
        <form:input path="user_password" id="user_password"/><br>
        <form:errors path="user_password" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td colspan='2'>
        <input type="submit" value="Register">
        <input type="reset" value="Reset" />
      </td>
    </tr>
  </form:form>
</table>

<%--<c:if test="${!empty users}">--%>
<%--<table align="left" border="1">--%>
<%--  <thead>--%>
<%--  <tr>--%>
<%--    <th>Name</th>--%>
<%--    <th>Password</th>--%>
<%--  </tr>--%>
<%--  </thead>--%>
<%--  <tbody>--%>
<%--  <c:forEach items="${users}" var="user">--%>
<%--    <tr>--%>
<%--      <c:url var="updateLink" value="/users/edit">--%>
<%--        <c:param name="student_id" value="${user.id}" />--%>
<%--      </c:url>--%>
<%--      <c:url var="deleteLink" value="/users/delete">--%>
<%--        <c:param name="student_id" value="${user.id}" />--%>
<%--      </c:url>--%>
<%--      <td>${user.name}</td>--%>
<%--      <td>${user.password}</td>--%>
<%--      <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--  </tbody>--%>
<%--</table>--%>
<%--</c:if>--%>
</body>
</html>
