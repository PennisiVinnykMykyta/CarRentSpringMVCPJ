<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Your Profile</title>
</head>
<body>

<h3>First Name: ${user.firstName}</h3>
<br>

<h3>Last Name: ${user.lastName}</h3>
<br>

<h3>Email: ${user.email}</h3>
<br>

<h3>Password: YOUR PASSWORD IS HIDDEN</h3>
<br>

<h3>Birthday: ${user.birthDate}</h3>
<br>

<form method="POST" action="./changeProfile">
    <input type="hidden" name="userToChangeID" value="${user.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" class="btn btn-warning" value="Change Profile Details">
</form>

<form method="GET" action="./homepage">
    <input type="submit" class="btn btn-primary" value="Go back">
</form>

</body>
</html>
