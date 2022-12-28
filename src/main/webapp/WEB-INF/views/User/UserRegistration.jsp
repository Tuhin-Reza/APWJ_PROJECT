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
<form:form action="submit" method="post" modelAttribute="user">
  <table>
    <tr>
      <td><label>Full Name</label></td>
      <td>
        <form:input  type="text" path="name" id="name" />
        <form:errors path="name" style="color:red" />
      </td>
    </tr>

    <tr>
      <td><label>Age</label></td>
      <td>
        <form:input type="numbere" path="age" id="age"/>
        <form:errors path="age" style="color:red" />
      </td>
    </tr>

    <tr>
      <td><label>Present Address</label></td>
      <td>
        <form:input type="text" path="address" id="address" />
        <form:errors path="address" style="color:red" />
      </td>
    </tr>

    <tr>
      <td><label>Profession</label></td>
      <td><form:select path="profession" id="profession">
        <form:option value="">Select Profession</form:option>
        <c:forEach items="${enums}" var="value">
          <option>${value}</option>
        </c:forEach>
      </form:select> <form:errors path="profession" style="color:red" /></td>
    </tr>

    <tr>
      <td><label>Username</label></td>
      <td>
        <form:input type="text" path="username" id="username"/>
        <form:errors path="username" style="color:red" />
        <label style="color:red">${unError}</label>
      </td>
    </tr>

    <tr>
      <td><label>Password</label></td>
      <td>
        <form:input type="password" path="password" id="password" />
        <form:errors path="password" style="color:red" />
        <label style="color:red">${passError}</label>
      </td>
    </tr>

    <tr>
      <td colspan="2"><input type="submit" value="Sign Up"></td>
    </tr>
  </table>
</form:form>


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
