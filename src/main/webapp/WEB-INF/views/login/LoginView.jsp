<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/29/2022
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <script>
        function isValid(pForm) {
            console.log(pForm.method);
            console.log(pForm.action);
            console.log(pForm.username.value);
            console.log(pForm.password.value);
            return true;
        }
    </script>
</head>
<%--users/Customer--%>
<body>
<form action="${pageContext.request.contextPath}/authentic" method="post" onsubmit="return isValid(this);">
    <table>
        <tr>
            <td><label>Username</label></td>
            <td>
                <input type="text" name="username" id="username"/>
            </td>
        </tr>
        <tr>
            <td><label>Password</label></td>
            <td>
                <input type="password" name="password" id="password" />
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Sign Up"></td>
        </tr>
    </table>
</form>
<%
    String isError = request.getQueryString();
    if (isError != null && isError.equals("error")) {
        out.println("Please fill up the form properly");
    }
%>
</body>
</html>