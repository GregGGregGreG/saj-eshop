<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value="/css/main.css" />"/>
</head>
<body>
    <c:if test="${authenticationFailed}">
        <div class="error">
            <p>Your login or password is invalid. Try again.</p>
        </div>
    </c:if>

    <fieldset id="login">
        <legend>Please authenticate</legend>
        <form action="<c:url value="/login" />" method="post">
            <p>
                <label for="loginInput">Login: </label>
                <input id="loginInput" type="text" name="login"/>
            </p>
            <p>
                <label for="passwordInput">Password: </label>
                <input id="passwordInput" type="password" name="password"/>
            </p>
            <p>
                <input type="submit"/>
            </p>
        </form>
    </fieldset>
</body>
</html>
