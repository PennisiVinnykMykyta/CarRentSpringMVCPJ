<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Change Profile</title>
</head>
<body>

<form method="POST" name="changeProfile" action="./save">
    First Name: <input type="text" name="firstName" value="${userToChange.firstName}">
    <br><br>

    Last Name: <input type="text" name="lastName" value="${userToChange.lastName}">
    <br><br>

    Email: <input type="text" name="email" value="${userToChange.email}">
    <br><br>

    Password: <input type="text" name="password" value="RE-INSERT YOUR PASSWORD OR SELECT A NEW ONE">
    <br><br>

    Birthday: <input type="text" name="birthDate" value="${userToChange.birthDate}">
    <br><br>

    <input type="hidden" name ="userID" value="${user.id}">
    <input type="hidden" name="userToChangeID" value="${userToChange.id}">
    <input type="hidden" name="type" value="other">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Save Changes">
</form>

    <form method="GET" name="logout" action="./homepage">
        <input type="hidden" name="email" value="${user.email}">
        <input type="hidden" name="password" value="${user.password}" >
        <input type="submit" value="Cancel">
    </form>

</table>

</body>
</html>
