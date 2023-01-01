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
<form:form method="post" action="customerUpdate" modelAttribute="customer" onsubmit="return isValid(this);">
    <table>
        <tr>
            <td>
                <form:input type="hidden" path="id" id="for" readonly="true"/>
                <form:errors path="id" cssClass="error"/>
            </td>
        </tr>

        <tr>
            <td><label>Full Name</label></td>
            <td>
                <form:input  type="text" path="name" id="name" />
                <form:errors path="name" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>Age</label></td>
            <td>
                <form:input type="numbere" path="age" id="age"/>
                <form:errors path="age" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>Present Address</label></td>
            <td>
                <form:input type="text" path="address" id="address" />
                <form:errors path="address" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Profession</label></td>
            <td>
                <form:select path="profession">
                    <form:option value="" label="Select Profession" />
                    <c:forEach items="${enums}" var="value">
                        <form:option value="${value}" label="${value}" />
                    </c:forEach>
                </form:select><form:errors path="profession" style="color:red"/>
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
            <td>
                <form:input type="hidden" path="password" id="password" />
                <form:errors path="password" style="color:red" />
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
