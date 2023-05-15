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

Password: ${user.password}
<br><br>

Birthday: ${user.birthDate}
<br><br>

<form method="POST" name="modifyProfile" action="./changeProfile">
    <input type="hidden" name="userID" value="${user.id}">
    <input type="hidden" name="userToChangeID" value="${user.id}">
    <input type="submit" value="Change Profile Details">
</form>

<form method="GET" name="revert" action="./homepage">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="password" value="${user.password}">
    <input type="submit" value="Go back">
</form>

</body>
</html>
