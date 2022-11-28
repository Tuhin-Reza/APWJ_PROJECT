<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/28/2022
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Edit</title>
</head>
<body>
<head>
  <title>Edit Department</title>
</head>
<body>
<form:form action="update" modelAttribute="student">
  <table>
    <tr>
      <td>Student ID</td>
      <td>
        <form:input path="student_id" id="for" readonly="true"/>
        <form:errors path="student_id"/>
      </td>
    </tr>
    <tr>
      <td>Student NAME</td>
      <td>
        <form:input path="student_name" id="stident_name"/>
        <form:errors path="student_name"/>
      </td>
    </tr>
  </table>

  <br><input type="submit" value="Edit Student">
</form:form>

</body>
</html>
