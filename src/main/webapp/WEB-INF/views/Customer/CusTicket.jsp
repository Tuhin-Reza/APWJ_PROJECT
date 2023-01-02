<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 1/2/2023
  Time: 9:48 AM
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
<c:if test="${!empty cusTickets}">
  <c:forEach items="${cusTickets}" var="cusTicket">
    <div class="flex-container" style="align-items: center">
      <div style="background-color:wheat;padding: 15px;margin-bottom: 15px;width: 40%;margin-left: auto;margin-right: auto">
        <table>
          <tbody>
          <tr>
            <td>Id</td>
            <td>${cusTicket.id}</td>
          </tr>
          <tr>
            <td>Username</td>
            <td>${cusTicket.cus_username}</td>
          </tr>
          <tr>
            <td>Route Id</td>
            <td>${cusTicket.routeId}</td>
          </tr>
          </tbody>

        </table>

      </div>

    </div>
  </c:forEach>
</c:if>


</body>
</html>
