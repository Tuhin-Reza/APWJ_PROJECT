<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/31/2022
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${account.username}</title>
</head>
<body>
<form:form action="amountUpdate" modelAttribute="account">
  <table>
    <tr>
      <td>
        <form:input type="hidden" path="id" id="for" readonly="true"/>
        <form:errors path="id" cssClass="error"/>
      </td>
    </tr>

    <tr>
      <td><label>Account Name</label></td>
      <td>
        <form:input type="text" path="username" id="username" readonly="true"/>
        <form:errors path="username" style="color:red" />
      </td>
    </tr>

    <tr>
      <td><form:label path="balance">Added Amount</form:label></td>
      <td>
        <form:input type="number" path="balance" min="200" value="0" pattern="[0-9]+"/>
        <form:errors path="balance" style="color:red" />
      </td>
    </tr>

    <tr>
      <td><input type="submit" value="Update"/></td>
    </tr>
  </table>
</form:form>
<c:url var="mainViewLink" value="/customers/main">
  <c:param name="id" value="${customer.id}" />
</c:url>
<br><br><button onclick="window.location.href='${mainViewLink}';return false;">Back</button>
</body>
</html>
