<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/31/2022
  Time: 10:32 AM
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
<form:form method="POST" action="amountAdded" modelAttribute="account">
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td>
                <form:input type="text" path="username" value="${customer.username}"  id="username" readonly="true"/>
                <form:errors path="username" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><form:label path="balance">Balance</form:label></td>
            <td>
                <form:input type="number" path="balance" min="200" pattern="[0-9]+"/>
                <form:errors path="balance" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
