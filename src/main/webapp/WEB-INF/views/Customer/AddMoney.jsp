<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/31/2022
  Time: 10:32 AM
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
            }

            return true;
        }
    </script>

</head>
<body>
<form:form method="post" action="amountAdded" modelAttribute="account" onsubmit="return isValid();">
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td>
                <form:input type="text" path="username" value="${customer.username}"  id="username" readonly="true"/>
                <form:errors path="username" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><form:label path="balance">Balance</form:label></td>
            <td>
                <form:input type="number" id="balance" path="balance"  pattern="[0-9]+"/>
                <form:errors path="balance" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<c:url var="mainViewLink" value="/customers/main">
    <c:param name="id" value="${customer.id}" />
</c:url>
<button onclick="window.location.href='${mainViewLink}';return false;">Back</button>
</body>
</html>
