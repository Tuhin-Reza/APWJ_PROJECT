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
<form:form action="confirmTicket" method="post" modelAttribute="route">
    <h6>Ticket Confirmation</h6><br>
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
        <tr>
            <td><label></label></td>
            <td>
                <input type="submit" value="Confirm Buy">
            </td>
        </tr>
    </table>
</form:form>
</div>



</body>
</html>
