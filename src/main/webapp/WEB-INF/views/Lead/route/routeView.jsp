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
    <title></title>
    <style type="text/css">
        .error {
            color: red;
        }  body {
               font-family: Arial, Helvetica, sans-serif;
               margin: 0;
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
                    darkgray,
                    darkgray
            ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        }

        .navbar {
            overflow: hidden;
            background-color: #333;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .subnav {
            float: left;
            overflow: hidden;
        }

        .subnav .subnavbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }

        .navbar a:hover, .subnav:hover .subnavbtn {
            background-color: red;
        }

        .subnav-content {
            display: none;
            position: absolute;
            left: 0;
            background-color: red;
            width: 100%;
            z-index: 1;
        }

        .subnav-content a {
            float: left;
            color: white;
            text-decoration: none;
        }

        .subnav-content a:hover {
            background-color: #eee;
            color: black;
        }

        .subnav:hover .subnav-content {
            display: block;
        }

        .btn1 {
            position: relative;
            display: block;
            overflow: hidden;
            width: 100%;
            height: 80px;
            max-width: 250px;
            margin: 1rem auto;
            text-transform: uppercase;
            /*   border: 1px solid currentColor; */
            color: white;
            line-height: 80px;
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
    </style>
</head>
<body>
<div class="navbar">
    <a href="http://localhost:8080/PROJECT_DTS_war_exploded/users/decision">Home</a>

    <div class="subnav">
        <button class="subnavbtn">Authority<i class="fa fa-caret-down"></i></button>
        <div class="subnav-content">
            <a href="http://localhost:8080/PROJECT_DTS_war_exploded/authorities/create">Create</a>
            <a href="http://localhost:8080/PROJECT_DTS_war_exploded/authorities/getAll">Authority list</a>
        </div>
    </div>
    <div class="subnav">
        <button class="subnavbtn">Route<i class="fa fa-caret-down"></i></button>
        <div class="subnav-content">
            <a href="http://localhost:8080/PROJECT_DTS_war_exploded/admin/routeCreate">Create</a>
        </div>
    </div>
    <br><br>


<form:form>
<c:if test="${!empty routes}">
    <table align="left" border="1">
        <thead>
        <tr>
            <th>Bus Name</th>
            <th>Boarding Point</th>
            <th>B_Bus Stoppage</th>
            <th>D_Bus Stoppage</th>
            <th>Dropping Point</th>
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
                <c:url var="updateLink" value="/admin/edit">
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
            </tr>
        </c:forEach>
        </div>
        </tbody>
    </table>
</c:if>
    </form:form>
</body>
</html>
