<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Add New User</title>
</head>
<body>
<div class="jumbotron">
    <h2>Enter the New Users Credentials</h2>
</div>

<form:form method="POST" action="/SpringMVCPJ_war_exploded/user/save" modelAttribute="userToChange">

    <h3>First Name:</h3>
    <form:input path="firstName"/>

    <h3>Last Name:</h3>
    <form:input path="lastName"/>

    <h3>Email:</h3>
    <form:input path="email"/>

    <h3>Password:</h3>
    <form:input path="password"/>

    <h3>Birthday:</h3>
    <form:input path="birthDate"/>

    <h3>Type of user:</h3>
    <h3>Admin</h3>
    <form:radiobutton path="userType" value="admin"/>
    <h3>Customer</h3>
    <form:radiobutton path="userType" value="customer"/>
    <br><br>

    <form:hidden path="id" value=""/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" class="btn btn-success" value="Save Changes">
</form:form>

<form method="GET" action="./homepage">
    <input type="submit" class="btn btn-primary" value="Cancel">
</form>

</table>


</body>
</html>
