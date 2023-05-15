<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>

<form method="POST" name="changeProfile" action="./save">
    First Name: <input type="text" name="firstName" />
    <br><br>

    Last Name: <input type="text" name="lastName" />
    <br><br>

    Email: <input type="text" name="email"/>
    <br><br>

    Password: <input type="text" name="password" />
    <br><br>

    Birthday: <input type="text" name="birthDate" />
    <br><br>

     Type of user:
    <br>
    <input type="radio" name="type" value="admin" />Admin
    <br>
    <input  type="radio" name="type" value="customer" checked="true" />Customer

    <br><br>

    <input type="hidden" name ="userID" value="${user.id}">
    <input type="hidden" name="userToChangeID" value="${user.id}">
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
