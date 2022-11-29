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
<
<input type="button" value="Add Student" onclick="window.location.href=' StudentRegistration.jsp';return false;"><br><br>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th> Name</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${student}" var="student">
    <tr>
      <c:url var="updateLink" value="/students/edit">
        <c:param name="student_id" value="${student.student_id}" />
      </c:url>
      <c:url var="deleteLink" value="/students/delete">
        <c:param name="student_id" value="${student.student_id}" />
      </c:url>
      <td>${student.student_id}</td>
      <td>${student.student_name}</td>
      <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
