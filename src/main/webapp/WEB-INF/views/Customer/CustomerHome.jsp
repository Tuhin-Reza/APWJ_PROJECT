<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/30/2022
  Time: 4:02 PM
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
<form:form>
<p><a href="logout">Logout</a></p>
<c:url var="viewLink" value="/customers/customerProfile">
    <c:param name="id" value="${customer.id}" />
</c:url>
<c:url var="updateLink" value="/customers/customerEdit">
    <c:param name="id" value="${customer.id}" />
</c:url>
<c:url var="addMoneyLink" value="/customers/amountAdded">
    <c:param name="id" value="${customer.id}" />
</c:url>
<c:url var="routeViewLink" value="/customers/routeList">
    <c:param name="id" value="${customer.id}" />
</c:url>
<c:url var="THViewLink" value="/customers/TransitionList">
    <c:param name="id" value="${customer.id}" />
</c:url>
<c:url var="CPViewLink" value="/customers/cngPass">
    <c:param name="id" value="${customer.id}" />
</c:url>
${customer.username}
Balance : ${amount}<br>
<input type="button" value="View Profile" onclick="window.location.href='${viewLink}';return false;"><br><br>
<input type="button" value="Update Profile" onclick="window.location.href='${updateLink}';return false;"><br><br>
<input type="button" value="Add Money" onclick="window.location.href='${addMoneyLink}';return false;"><br><br>
<input type="button" value="Route View" onclick="window.location.href='${routeViewLink}';return false;"><br><br>
<input type="button" value="Transition History" onclick="window.location.href='${THViewLink}';return false;"><br><br>
<input type="button" value="Change Password" onclick="window.location.href='${CPViewLink}';return false;"><br><br>
</form:form>
</body>
</html>
