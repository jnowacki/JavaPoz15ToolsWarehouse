<%--
  Created by IntelliJ IDEA.
  User: jedrz
  Date: 04.08.2019
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    table, th, td {
        border: 1px solid black;
    }

    .red {
        background-color: red;
    }

    .green {
        background-color: green;
    }
</style>

<body>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Type</th>
        <th>Available</th>
    </tr>
    <c:forEach items="${requestScope.tools}" var="tool">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.name}</td>
            <td>${tool.type}</td>
            <td class="${tool.available ? 'green' : 'red'}"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>