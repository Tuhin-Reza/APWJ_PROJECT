<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/29/2022
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
    <title>Title</title>
</head>
<body>
<form:form action="routeSubmit" modelAttribute="route">
    <table>
        <tr>
            <td><label>Form</label></td>
            <td>
                <form:input  type="text" path="from" id="from" />
                <form:errors path="from" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>To</label></td>
            <td>
                <form:input type="text" path="destination" id="destination" />
                <form:errors path="destination" style="color:red" />
            </td>
        </tr>
    </table>
    <br><input type="submit" value="Submit">
</form:form>

</body>
</html>
