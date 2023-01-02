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
    <script>
        function isValid() {
            const name = document.getElementById("name").value;
            const age  = document.getElementById("age").value;
            const address = document.getElementById("address").value;
            const profession = document.getElementById("profession").value;
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;


            if(name ===""){
                document.getElementById("nameErr").innerHTML="*full name required";
                return false;
            }else if(name.length<5 || name.length>20){
                document.getElementById("nameErr").innerHTML="*min length(5) & max length(20)";
                return false;
            }else if(name.match(/^[0-9a-zA-Z]+$/)){
                document.getElementById("nameErr").innerHTML="*alphaNumeric value not allowed";
                return false;
            }else{
                document.getElementById("nameErr").innerHTML=" ";
            }

            if(age===""){
                document.getElementById("ageErr").innerHTML="*age required";
                return false;
            }else if(age<15){
                document.getElementById("ageErr").innerHTML="*age must be(15)";
                return false;
            }else{
                document.getElementById("ageErr").innerHTML=" ";
            }

            if(address ===""){
                document.getElementById("addressErr").innerHTML="*address required";
                return false;
            }else if(address.length<5){
                document.getElementById("addressErr").innerHTML="*min length(5)";
                return false;
            }else{
                document.getElementById("addressErr").innerHTML=" ";
            }


            if(profession ===""){
                document.getElementById("professionErr").innerHTML="*profession required";
                return false;
            }else{
                document.getElementById("professionErr").innerHTML=" ";
            }


            if(username===""){
                document.getElementById("userErr").innerHTML="*username required";
                return false;
            }if(username.length<3){
                document.getElementById("userErr").innerHTML="*must be length(3)";
                return false;
            }else if(!username.match(/^[a-z0-9]+$/)){
                document.getElementById("userErr").innerHTML="*must be(small letter+alphanumeric";
                return false;
            }
            else if(username.match(/^[0-9]+$/)){
                document.getElementById("userErr").innerHTML="*must be(small letter+alphanumeric";
                return false;
            }else{
                document.getElementById("userErr").innerHTML=" ";
            }


            if(password ===""){
                document.getElementById("passErr").innerHTML="*password required";
                return false;
            }else if(password.length>4){
                document.getElementById("passErr").innerHTML="*minimum length(4)";
                return false;
            }else if(password.match(/^[A-Za-z]+$/)){
                document.getElementById("passErr").innerHTML="*only decimal number";
                return false;
            }else{
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

    <style>
        body {
            background: whitesmoke; /* fallback for old browsers */
            background: -webkit-linear-gradient(
                    to right,
                    #1184ff,
                    #19d5ff
            ); /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(
                    to right,
                    silver,
                    silver
            ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: silver;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: silver;
        }

        .active {
            background-color: black;
        }
    </style>
</head>
<body>

<form:form >
    <c:url var="mainViewLink" value="/customers/main">
        <c:param name="id" value="${customer.id}" />
    </c:url>
    <ul>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li style="float:right"><a class="active" onclick="window.location.href='${mainViewLink}';return false;">Back</a></li>
    </ul>
</form:form>

<div style="align-items: center;  margin-top: 15px;padding-left: 400px">
<form:form method="post" action="customerUpdate" modelAttribute="customer" onsubmit="return isValid();">
    <h3>Profile Update</h3>
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
                <small style="color:red"><span id="nameErr"></span></small>
            </td>
        </tr>

        <tr>
            <td><label>Age</label></td>
            <td>
                <form:input type="numbere" path="age" id="age"/>
                <form:errors path="age" style="color:red" />
                <small style="color:red"><span id="ageErr"></span></small>
            </td>
        </tr>

        <tr>
            <td><label>Present Address</label></td>
            <td>
                <form:input type="text" path="address" id="address" />
                <form:errors path="address" style="color:red" />
                <small style="color:red"><span id="addressErr"></span></small>
            </td>
        </tr>
        <tr>
            <td><label>Profession</label></td>
            <td>
                <form:select path="profession">
                    <form:option value="" label="Select Profession" id="profession" />
                    <c:forEach items="${enums}" var="value">
                        <form:option value="${value}" label="${value}" />
                    </c:forEach>
                </form:select><form:errors path="profession" style="color:red"/>
                <small style="color:red"><span id="professionErr"></span></small>
            </td>
        </tr>
        <tr>
            <td><label>Username</label></td>
            <td>
                <form:input type="text" path="username" id="username" readonly="true"/>
                <form:errors path="username" style="color:red" />
                <small style="color:red"><span id="userErr"></span></small>
            </td>
        </tr>
        <tr>
            <td><label>Password</label></td>
            <td>
                <form:input type="password" path="password" id="password" value=" "/>
                <form:errors path="password" style="color:red" />
                <small style="color:red"><span id="passErr"></span></small>
                <br><input type="checkbox" onclick="myFunction()"> <small>Show Password</small>
            </td>
        </tr>
        <tr>
            <td><label></label></td>
            <td>
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
