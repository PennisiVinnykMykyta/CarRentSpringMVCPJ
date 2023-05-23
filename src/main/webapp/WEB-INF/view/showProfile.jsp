<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Your Profile</title>
</head>
<body>

First Name: ${user.firstName}
<br><br>

Last Name: ${user.lastName}
<br><br>

Email: ${user.email}
<br><br>

Password: YOUR PASSWORD IS HIDDEN
<br><br>

Birthday: ${user.birthDate}
<br><br>

<form method="POST" action="./changeProfile">
    <input type="hidden" name="userToChangeID" value="${user.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Change Profile Details">
</form>

<form method="GET" action="./homepage">
    <input type="submit" value="Go back">
</form>

</body>
</html>
