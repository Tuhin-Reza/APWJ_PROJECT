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
  <script>
    function isValid() {
      const value = document.getElementById("balance").value;
      if(value<200){
        alert("value"+"*amount must be greater 200");
        return false;
      }
      return true;
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
<form:form method="post" action="amountUpdate" modelAttribute="account" onsubmit="return isValid();">
  <h3>Amount Added</h3>
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
        <form:input type="number" path="balance"  value="0"/>
        <form:errors path="balance" style="color:red" />
        <small style="color:red"><span id="addressErr"></span></small>
      </td>
    </tr>
    <tr>

    <tr>
      <td></td>
      <td>
        <input type="submit" value="Update"/>
      </td>
    </tr>
  </table>
</form:form>
</div>

</body>
</html>
