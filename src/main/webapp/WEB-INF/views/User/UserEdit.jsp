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
        <form:input path="id" id="for" readonly="true"/>
        <form:errors path="id" cssClass="error"/>
      </td>
    </tr>

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
        <form:option value="${user.profession}">${user.profession}</form:option>
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
      </td>
    </tr>

    <tr>
      <td><label>Password</label></td>
      <td>
        <form:input type="password" path="password" id="password" />
        <form:errors path="password" style="color:red" />
      </td>
    </tr>
  </table>
  <br><input type="submit" value="Update">
</form:form>
</body>
</html>
