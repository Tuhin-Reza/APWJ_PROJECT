<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/29/2022
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<input type="button" value="Add Route" onclick="window.location.href='routeCreate';return false;"><br><br>
<c:if test="${!empty routes}">
    <table align="left" border="1">
        <thead>
        <tr>
            <th>Form</th>
            <th>To</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${routes}" var="route">
            <tr>
                <c:url var="updateLink" value="/admin/edit">
                    <c:param name="id" value="${route.id}" />
                </c:url>
                <c:url var="deleteLink" value="/admin/delete">
                    <c:param name="id" value="${route.id}" />
                </c:url>
                <td>${route.from}</td>
                <td>${route.destination}</td>
                <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
