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
            const username =pForm.username.value ;
            const pass     = pForm.password.value;

            if(username ===""){
                document.getElementById("userErr").innerHTML="Invalid Username";
                return false;
            }else{
                document.getElementById("userErr").innerHTML=" ";
            }

            if(pass ===""){
                document.getElementById("passErr").innerHTML="Invalid Password";
                return false;
            }
            else{
                document.getElementById("passErr").innerHTML=" ";
            }
            return true;
        }
        function myFunction() {
            const x = document.getElementById("password");
            if (x.type === "password"){
                x.type = "text";
            }else{
                x.type = "password";
            }
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/authentic" method="post" onsubmit="return isValid(this);">
    <table>
        <tr>
            <td><label>Username</label></td>
            <td>
                <input type="text" name="username" id="username"/>
                <small><p id="userErr"></p></small>
            </td>
        </tr>
        <tr>
            <td><label>Password</label></td>
            <td>
                <input type="password" name="password" id="password" /><br>
                <input type="checkbox" onclick="myFunction()"> <small>Show Password</small>
                <small><p id="passErr"></p></small>
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