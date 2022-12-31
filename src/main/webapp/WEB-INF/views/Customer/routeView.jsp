<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/29/2022
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${customer.username}</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<input type="button" value="Add Route" onclick="window.location.href='routeCreate';return false;"><br><br>
<c:if test="${!empty routes}">
    <table align="left" border="1">
        <thead>
        <tr>
            <th>Bus Name</th>
            <th>Boarding Point</th>
            <th>B_Bus Stoppage</th>
            <th>D_Bus Stoppage</th>
            <th>Dropping Point</th>
            <th>D_Bus Stoppage</th>
            <th>Time</th>
            <th>Distance</th>
            <th>Fare</th>
            <th>Driver Name</th>
        </tr>
        </thead>
        <tbody>
        <div class="cards">
        <c:forEach items="${routes}" var="route">
            <tr class="card">
                <c:url var="ticketLink" value="/admin/buyTicket">
                    <c:param name="id" value="${route.id}" />
                </c:url>
                <td>${route.busName}</td>
                <td>${route.boardingPoint}</td>
                <td>${route.b_busStoppage}</td>
                <td>${route.droppingPoint}</td>
                <td>${route.d_busStoppage}</td>
                <td>${route.b_time}</td>
                <td>${route.distance}</td>
                <td>${route.fare}</td>
                <td>${route.driverName}</td>
                <td><a href="${ticketLink}">Buy Ticket</a></td>
            </tr>
        </c:forEach>
        </div>
        </tbody>
    </table>
</c:if>
</body>
</html>
