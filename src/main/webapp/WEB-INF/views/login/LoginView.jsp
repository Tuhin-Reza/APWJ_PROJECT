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
    <title>Log in Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .login-form {
            width: 340px;
            margin: 50px auto;
        }
        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .login-form h2 {
            margin: 0 0 15px;
        }
        .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
        }
        .btn {
            font-size: 15px;
            font-weight: bold;
        }
    </style>
    <script>
        function isValid(pForm) {
            const username =pForm.username.value ;
            const pass     = pForm.password.value;

            if(username ===""){
                document.getElementById("userErr").innerHTML="*invalid";
                return false;
            }else{
                document.getElementById("userErr").innerHTML=" ";
            }

            if(pass ===""){
                document.getElementById("passErr").innerHTML="*invalid";
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
    <div class="login-form">
        <form aaction="${pageContext.request.contextPath}/authentic" method="post" onsubmit="return isValid(this);">
            <h2>Log in</h2>
            <div class="form-group">
                <input type="text" name="username" id="username" placeholder="Username"/>
                <span style="color:red " id="userErr"></span>
            </div>
            <div class="form-group">
                <input type="password" name="password" id="password"  placeholder="Password"/>
                <span style="color:red" id="passErr"></span>
                <br><span><input type="checkbox" onclick="myFunction()">Show Password</span>
            </div>
            <span style="color:red">${error}</span>
            <div class="form-group">
                <button type="submit" >Sign in</button>
            </div>
            <div>
                <a href="#">Forgot Password?</a>
            </div>
        </form>

    </div>


<%--    Username :--%>
<%--    <input type="text" name="username" id="username"/>--%>
<%--    <span style="color:red" id="userErr"></span>--%>

<%--    Password :--%>
<%--    <input type="password" name="password" id="password" />--%>
<%--    <input type="checkbox" onclick="myFunction()">--%>
<%--    <span>Show Password</span>--%>
<%--    <span style="color:red" id="passErr"></span>--%>
<%--    <span style="color:red">${error}</span><br>--%>

<%--    <input type="submit" value="Sign Up">--%>

</form>
</body>
</html>