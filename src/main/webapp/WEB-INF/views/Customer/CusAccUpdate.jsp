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
      // const username =pForm.b;
      // if(username ===""){
      //     document.getElementById("userErr").innerHTML="Invalid Username";
      //     return false;
      // }else{
      //     document.getElementById("userErr").innerHTML=" ";
      // }
      const value = document.getElementById("balance").value;
      if(value<200){
        alert("value");
        return false;
      }

      return true;
    }
  </script>
</head>
<body>
<form:form method="post" action="amountUpdate" modelAttribute="account" onsubmit="return isValid();">
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
        <form:input type="number" path="balance"  value="0" pattern="[0-9]+"/>
        <form:errors path="balance" style="color:red" />
      </td>
    </tr>

    <tr>
      <td><input type="submit" value="Update"/></td>
    </tr>
  </table>
</form:form>
<c:url var="mainViewLink" value="/customers/main">
  <c:param name="id" value="${customer.id}" />
</c:url>
<br><br><button onclick="window.location.href='${mainViewLink}';return false;">Back</button>
</body>
</html>
