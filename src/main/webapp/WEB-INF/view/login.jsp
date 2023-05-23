<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Login Page</title>
</head>
<body>

<div class="jumbotron text-center">
    <h1>Welcome to the CarRent Site!</h1>
    <br>
    <p>Please enter your credentials:</p>
</div>

<form method="POST" action="./login" class="form-horizontal">
    <c:if test="${param.error != null}">
        <p class="text-center">Invalid Credentials!</p>
        <br><br>
    </c:if>
    <c:if test="${param.logout != null}">
        <p class="text-center">You have logged out!</p>
        <br><br>
    </c:if>
    <table>
        <p class="text-center">Email:</p>
        <p class="text-center"><input type="text" id="email" name="email" placeholder = "email" /></p>

        <p class="text-center">Password:</p>
        <p class="text-center"><input type="text" id="password" name="password" placeholder ="password" /></p>

    </table>
    <br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <p class="text-center"><input type="submit" class = "btn btn-primary" value="Log In"/></p>

</form>

</body>
</html>
