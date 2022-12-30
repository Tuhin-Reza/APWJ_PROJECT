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
<c:url var="viewLink" value="/customers/customerProfile">
    <c:param name="id" value="${customer.id}" />
</c:url>
<c:url var="updateLink" value="/customers/customerEdit">
    <c:param name="id" value="${customer.id}" />
</c:url>
<input type="button" value="View Profile" onclick="window.location.href='${viewLink}';return false;"><br><br>
<input type="button" value="Update Profile" onclick="window.location.href='${updateLink}';return false;"><br><br>
${customer.name}
${customer.profession}
</body>
</html>
