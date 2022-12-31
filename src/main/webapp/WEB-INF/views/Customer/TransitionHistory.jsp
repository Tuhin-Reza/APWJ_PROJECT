<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 1/1/2023
  Time: 2:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${username}</title>
</head>
<body>
<c:if test="${!empty transition}">
    <table align="left" border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>User Name</th>
            <th>Transition</th>
            <th>Amount</th>
            <th>Available Balance</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${transition.id}</td>
            <td>${transition.username}</td>
            <td>${transition.transition}</td>
            <td>${transition.amount}</td>
            <td>${transition.avail_balance}</td>
        </tr>
        </tbody>
    </table>
</c:if>
<c:url var="mainViewLink" value="/customers/main">
    <c:param name="id" value="${customer.id}" />
</c:url>
<br><br><button onclick="window.location.href='${mainViewLink}';return false;">Back</button>
</body>
</html>
