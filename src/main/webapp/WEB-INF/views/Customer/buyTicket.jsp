<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/31/2022
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${username}</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form action="confirmTicket" method="post" modelAttribute="route">
    <table>
        <tr>
            <td>
                <form:input  type="hidden" path="id" id="id" />
                <form:errors path="id" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Bus Name</label></td>
            <td>
                <form:input  type="text" path="busName" id="busName" />
                <form:errors path="busName" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Boarding Point</label></td>
            <td>
                <form:input  type="text" path="boardingPoint" id="boardingPoint" readonly="true" />
                <form:errors path="boardingPoint" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Dropping Point</label></td>
            <td>
                <form:input  type="text" path="droppingPoint" id="droppingPoint" readonly="true"/>
                <form:errors path="droppingPoint" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Boarding Bus Stoppage</label></td>
            <td>
                <form:input  type="text" path="b_busStoppage" id="b_busStoppage" readonly="true" />
                <form:errors path="b_busStoppage" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Dropping Bus Stoppage</label></td>
            <td>
                <form:input  type="text" path="d_busStoppage" id="d_busStoppage" readonly="true" />
                <form:errors path="d_busStoppage" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Driver Name</label></td>
            <td>
                <form:input  type="text" path="driverName" id="driverName" readonly="true" />
                <form:errors path="driverName" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Destination Time</label></td>
            <td>
                <form:input  type="text" path="b_time" id="b_time" readonly="true"  />
                <form:errors path="b_time" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Distance</label></td>
            <td>
                <form:input  type="text" path="distance" id="distance" readonly="true"  />
                <form:errors path="distance" style="color:red" />
            </td>
        </tr>
        <tr>
            <td><label>Fare</label></td>
            <td>
                <form:input  type="number" path="fare" id="fare" readonly="true" />
                <form:errors path="fare" style="color:red" />
            </td>
        </tr>
    </table>
    <br><input type="submit" value="Confirm Buy">
</form:form>
<c:url var="mainViewLink" value="/customers/main">
    <c:param name="id" value="${customer.id}" />
</c:url>
<br><br><button onclick="window.location.href='${mainViewLink}';return false;">Back</button>

</body>
</html>
