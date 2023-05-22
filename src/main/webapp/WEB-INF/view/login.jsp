<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>

    <title>Login Page</title>
</head>
<body>

<h1>Welcome to the CarRent Site!</h1>

<form method="POST" action="./login" class="form-horizontal">
    <h4>Please enter your credentials:</h4>
    <c:if test="${param.error != null}">
        Invalid Credentials!
        <br><br>
    </c:if>
    <c:if test="${param.logout != null}">
        You have logged out!
        <br><br>
    </c:if>
    <table>
        Email:
        <input type="text" id="email" name="email" placeholder = "email" />

        Password:
        <input type="text" id="password" name="password" placeholder ="password" />

    </table>
    <br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Log In"/>

</form>

</body>
</html>
