<%--
  Created by IntelliJ IDEA.
  User: jedrz
  Date: 10.08.2019
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="hidden" name="action" value="login">
    Username: <input type="text" name="username"><br>
    Password: <input type="text" name="password"><br>
    <input type="submit" value="Log in">
</form>

<c:if test="${requestScope.invalidData}">
    <h1>Login data invalid</h1>
</c:if>

</body>
</html>
