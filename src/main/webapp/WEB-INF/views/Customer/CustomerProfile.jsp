<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/30/2022
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${customer.username}</title>
</head>
<body>
<input type="button" value="Add User" onclick="window.location.href='create';return false;"><br><br>
<c:if test="${!empty customer}">
    <table align="left" border="1">
        <thead>
        <tr>
            <th>Full Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Profession</th>
            <th>Username</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${customer.name}</td>
                <td>${customer.age}</td>
                <td>${customer.address}</td>
                <td>${customer.profession}</td>
                <td>${customer.username}</td>
            </tr>
        </tbody>
    </table>
</c:if>
</body>
</html>
