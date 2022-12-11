<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/28/2022
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student View</title>
</head>
<body>
<br>
<input type="button" value="Add User" onclick="window.location.href='create';return false;"><br><br>
<c:if test="${!empty users}">
  <table align="left" border="1">
    <thead>
    <tr>
      <th>Name</th>
      <th>Password</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
      <tr>
        <c:url var="updateLink" value="/users/edit">
          <c:param name="user_id" value="${user.user_id}" />
        </c:url>
        <c:url var="deleteLink" value="/users/delete">
          <c:param name="user_id" value="${user.user_id}" />
        </c:url>
        <td>${user.user_name}</td>
        <td>${user.user_password}</td>
        <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>
</body>
</html>
