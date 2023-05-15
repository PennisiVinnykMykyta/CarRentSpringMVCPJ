<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>

    <title>Login Page</title>
</head>
<body>

<h1>Welcome to the CarRent Site!</h1>

<br>
<h2>${error}</h2>
<br><br>


<form method="GET" name="login" action="./user/homepage">
    <h4>Please enter your credentials:</h4>
    <table>
        Email:
        <input type="text" name="email">

        Password:
        <input type="text" name="password">

    </table>
    <br><br>
    <input type="submit" value="Log In"/>

</form>

</body>
</html>
