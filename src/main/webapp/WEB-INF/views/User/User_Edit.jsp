<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/28/2022
  Time: 11:39 PM
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
    <title>User Edit</title>
</head>
<body>
<form:form action="update" modelAttribute="user">
  <table>
    <tr>
      <td>User ID</td>
      <td>
        <form:input path="user_id" id="for" readonly="true"/>
        <form:errors path="user_id" cssClass="error"/>
      </td>
    </tr>

    <tr>
      <td>User NAME</td>
      <td>
        <form:input path="user_name" id="user_name"/>
        <form:errors path="user_name" cssClass="error"/>
      </td>
    </tr>

    <tr>
      <td>User Password</td>
      <td>
        <form:input path="user_password" id="user_password"/>
        <form:errors path="user_password" cssClass="error"/>
      </td>
    </tr>

  </table>
  <br><input type="submit" value="Update">
</form:form>
</body>
</html>
