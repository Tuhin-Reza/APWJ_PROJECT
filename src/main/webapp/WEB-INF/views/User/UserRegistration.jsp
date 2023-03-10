<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/20/2022
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <script src="js.js" defer></script>
  <style type="text/css">
    .error {
      color: red;
    }
  </style>
  <title>Registration</title>
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
        document.getElementById("ageErr").innerHTML="*age must be(5)";
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
</head>


<body style="background-color: silver;margin-left: 400px;margin-top: 100px">
<form:form  action="submit" method="post" modelAttribute="user" onsubmit="return isValid();">
  <table>
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
        <form:input type="number" path="age" id="age"/>
        <form:errors path="age" style="color:red" />
        <small style="color:red"><span id="ageErr"></span></small>
      </td>
    </tr>

    <tr>
      <td><label>Present Address</label></td>
      <td>
        <form:input type="text" path="address" id="address"/>
        <form:errors path="address" style="color:red" />
        <small style="color:red"><span id="addressErr"></span></small>
      </td>
    </tr>

    <tr>
      <td><label>Profession</label></td>
      <td><form:select path="profession" id="profession">
        <form:option value="">Select Profession</form:option>
        <c:forEach items="${enums}" var="value">
          <option>${value}</option>
        </c:forEach>
      </form:select> <form:errors path="profession" style="color:red" />
        <small style="color:red"><span id="professionErr"></span></small>
      </td>

    </tr>

    <tr>
      <td><label>Username</label></td>
      <td>
        <form:input type="text" path="username" id="username"/>
        <form:errors path="username" style="color:red" />
        <small style="color:red"+><span>${unError}</span></small>
        <small style="color:red"><span id="userErr"></span></small>
      </td>
    </tr>

    <tr>
      <td><label>Password</label></td>
      <td>
        <form:input type="password" path="password" id="password" />
        <form:errors path="password" style="color:red" />
        <small style="color:red"><span id="passErr"></span></small>
        <br><input type="checkbox" onclick="myFunction()"> <small>Show Password</small>
      </td>
    </tr>

    <tr>
      <td colspan="2"><input type="submit" value="Sign Up"></td>
    </tr>
    <a href="http://localhost:8080/PROJECT_DTS_war_exploded/users/login">account yet?</a>
  </table>
  <a href="http://localhost:8080/PROJECT_DTS_war_exploded/users/login">account yet?</a>
</form:form>
</body>
</html>
