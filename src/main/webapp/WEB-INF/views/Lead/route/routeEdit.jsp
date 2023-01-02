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
    <title>Title</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
    <style>
        body {
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
<form:form action="update" modelAttribute="route">
    <table>
        <tr>
            <td><label>Bus Name </label></td>
            <td>
                <form:input type="text" path="busName" id="busName" />
                <form:errors path="busName" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>Boarding Point</label></td>
            <td>
                <form:input type="text" path="boardingPoint" id="boardingPoint" />
                <form:errors path="boardingPoint" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>DroppingPoint</label></td>
            <td>
                <form:input type="text" path="droppingPoint" id="droppingPoint" />
                <form:errors path="droppingPoint" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>B_busStoppage</label></td>
            <td>
                <form:input type="text" path="b_busStoppage" id="b_busStoppage" />
                <form:errors path="b_busStoppage" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>D_busStoppage</label></td>
            <td>
                <form:input type="text" path="d_busStoppage" id="d_busStoppage" />
                <form:errors path="d_busStoppage" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label></label></td>
            <td>
                <form:input type="text" path="driverName" id="driverName" />
                <form:errors path="driverName" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>B_time</label></td>
            <td>
                <form:input type="text" path="b_time" id="b_time" />
                <form:errors path="b_time" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>distance</label></td>
            <td>
                <form:input type="number" path="distance" id="distance" />
                <form:errors path="distance" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label>fare</label></td>
            <td>
                <form:input type="number" path="fare" id="fare" />
                <form:errors path="fare" style="color:red" />
            </td>
        </tr>

        <tr>
            <td><label></label></td>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
