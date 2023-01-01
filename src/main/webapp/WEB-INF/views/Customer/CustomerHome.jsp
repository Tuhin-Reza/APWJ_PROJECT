<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 12/30/2022
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${customer.username}</title>
    <style>
        a:link, a:visited {
            background-color:hsl(0, 0%, 30%);
            color: white;
            padding: 15px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
        a:hover, a:active {
            background-color:hsl(0, 0%, 30%);
        }

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

        .btn1 {
            position: relative;
            display: block;
            overflow: hidden;
            width: 100%;
            height: 50px;
            max-width: 250px;
            margin: 1rem auto;
            text-transform: uppercase;
            /*   border: 1px solid currentColor; */
            color: white;
            line-height: 50px;
            text-align: center;
            transition: ease 0.5s;
            font-family: "Nunito";
            font-size: 20px;
            box-shadow: -3px 9px 20px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
        }

        .btn1:before {
            content: "";
            position: absolute;
            top: 0;
            right: -50px;
            bottom: 0;
            left: 0;
            border-right: 50px solid transparent;
            border-bottom: 80px solid white;
            -webkit-transform: translateX(-100%);
            transform: translateX(-100%);
            transition: cubic-bezier(1, -0.02, 0.26, 0.38) 0.5s;
            z-index: -1;
        }

        .btn1:hover {
            color: #00c3ff;
        }

        .btn1:hover:before {
            transform: translateX(0);
        }

        ul {
            margin-top: 5px;
            display: block;
            text-align: center;
        }

        ul li {
            display: inline-block;
        }

        li {
            list-style: none;
            /*   float: left; */
            width: 200px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<p typeof="hide"><a href="logout">Logout</a></p>
<c:url var="CPViewLink" value="logout">
</c:url>
<form:form>
    <c:url var="viewLink" value="/customers/customerProfile">
        <c:param name="id" value="${customer.id}" />
    </c:url>
    <c:url var="updateLink" value="/customers/customerEdit">
        <c:param name="id" value="${customer.id}" />
    </c:url>
    <c:url var="addMoneyLink" value="/customers/amountAdded">
        <c:param name="id" value="${customer.id}" />
    </c:url>
    <c:url var="routeViewLink" value="/customers/routeList">
        <c:param name="id" value="${customer.id}" />
    </c:url>
    <c:url var="THViewLink" value="/customers/TransitionList">
        <c:param name="id" value="${customer.id}" />
    </c:url>

    Username :${customer.username}
    <ul>
        <li><a class="btn1" onclick="window.location.href='${addMoneyLink}';return false;">Balance :${amount}</a></li>
        <li><a class="btn1" onclick="window.location.href='${viewLink}';return false;">View Profile</a></li>
        <li><a class="btn1" onclick="window.location.href='${updateLink}';return false;">Update Profile</a></li>
        <li><a class="btn1" onclick="window.location.href='${addMoneyLink}';return false;">Ticket History</a></li>
        <li><a class="btn1" onclick="window.location.href='${THViewLink}';return false;">Transition History</a></li>
        <li><a class="btn1" onclick="window.location.href='${CPViewLink}';return false;">Logout</a></li>
    </ul>

<%--<input type="button" value="View Profile" onclick="window.location.href='${viewLink}';return false;"><br><br>--%>
<%--<input type="button" value="Update Profile" onclick="window.location.href='${updateLink}';return false;"><br><br>--%>
<%--<input type="button" value="Add Money" onclick="window.location.href='${addMoneyLink}';return false;"><br><br>--%>
<%--<input type="button" value="Route View" onclick="window.location.href='${routeViewLink}';return false;"><br><br>--%>
<%--<input type="button" value="Transition History" onclick="window.location.href='${THViewLink}';return false;"><br><br>--%>
<%--<input type="button" value="Change Password" onclick="window.location.href='${CPViewLink}';return false;"><br><br>--%>
</form:form>
<c:if test="${!empty routes}">
    <c:forEach items="${routes}" var="route">
        <div class="flex-container" style="align-items: center">
            <div style="background-color:wheat;padding: 15px;margin-bottom: 15px;width: 40%;margin-left: auto;margin-right: auto">
                <table>
                    <tbody>
                    <c:url var="ticketLink" value="/customers/buyTicket">
                        <c:param name="id" value="${route.id}" />
                    </c:url>
                    <tr>
                        <td>Id</td>
                        <td>${route.id}</td>
                    </tr>
                    <tr>
                        <td>Bus Name</td>
                        <td>${route.busName}</td>
                    </tr>
                    <tr>
                        <td>Boarding Point</td>
                        <td>${route.boardingPoint}</td>
                    </tr>
                    <tr>
                        <td>B_Bus Stoppage</td>
                        <td>${route.b_busStoppage}</td>

                    </tr>
                    <tr>
                        <td>Dropping Point</td>
                        <td>${route.droppingPoint}</td>
                    </tr>
                    <tr>
                        <td>D_Bus Stoppage</td>
                        <td>${route.d_busStoppage}</td>
                    </tr>
                    <tr>
                        <td>Driver Name</td>
                        <td>${route.driverName}</td>
                    </tr>
                    <tr>
                        <td>Boarding Time</td>
                        <td>${route.b_time}</td>
                    </tr>
                    <tr>
                        <td>Distance</td>
                        <td>${route.distance}</td>
                    </tr>
                    <tr>
                        <td>Fare</td>
                        <td>${route.fare}</td>
                    </tr><br>
                    <tr>
                        <td>Action </td>
                        <td><a class="btn1" onclick="window.location.href='${ticketLink}';return false;" >Buy Ticket</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </c:forEach>
</c:if>
</body>
</html>
