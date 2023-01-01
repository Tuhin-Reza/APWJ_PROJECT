<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 1/1/2023
  Time: 4:31 AM
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
<form:form method="post" action="cngPassUpdate" modelAttribute="customer" onsubmit="return isValid(this);">
  <table>
    <tr>
      <td>
        <form:input type="hidden" path="id" id="for" readonly="true"/>
        <form:errors path="id" cssClass="error"/>
      </td>
    </tr>
    <tr>
      <td><label>Username</label></td>
      <td>
        <form:input type="text" path="username" id="username" readonly="true"/>
        <form:errors path="username" style="color:red" />
      </td>
    </tr>
    <tr>
      <td><label>New Password</label></td>
      <td>
        <form:input type="password" path="password" id="password" value="null"/>
        <form:errors path="password" style="color:red" />
        <label style="color:red">${passError1}</label>
        <label style="color:red">${passError2}</label>
      </td>
    </tr>
  </table>
  <br><input type="submit" value="Update">
</form:form>
<c:url var="mainViewLink" value="/customers/main">
  <c:param name="id" value="${customer.id}" />
</c:url>
<button onclick="window.location.href='${mainViewLink}';return false;">Back</button>

</body>
</html>
