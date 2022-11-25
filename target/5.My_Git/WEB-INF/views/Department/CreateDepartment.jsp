<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/14/2022
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Department</title>
</head>
<body>
<form:form action="departmentStore" modelAttribute="department">
    <table>
        <tr>
            <td>Department Name</td>
            <td><form:input path="name" id="DepartmentName"/>
            <form:errors path="name"/>
            </td>
        </tr>
    </table>
    <br><input type="submit" value="Create">
</form:form>

</body>
</html>
