<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/14/2022
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Department Details</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<input type="button" value="Add Department" onclick="window.location.href='createDepartment';return false;">
<br><br>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Department Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departments}" var="department">
        <tr>
            <c:url var="updateLink" value="/Departments/edit">
                <c:param name="departmentId" value="${department.id}" />
            </c:url>
            <c:url var="deleteLink" value="/Departments/delete">
                <c:param name="departmentId" value="${department.id}" />
            </c:url>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
