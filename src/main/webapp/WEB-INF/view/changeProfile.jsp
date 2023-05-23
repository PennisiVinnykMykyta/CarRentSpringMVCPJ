<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Change Profile</title>
</head>
<body>

<form:form method="POST" action="/SpringMVCPJ_war_exploded/user/save" modelAttribute="userToChange">

    <form:label path="firstName"><h3>First Name:</h3></form:label>
    <br>
    <form:input path="firstName" />
    <br>

    <form:label path="lastName"><h3>Last Name:</h3></form:label>
    <br>
    <form:input path="lastName" />
    <br>

    <form:label path="email"><h3>Email:</h3></form:label>
    <br>
    <form:input path="email" />
    <br>

    <h3>Password: RE-INSERT YOUR PASSWORD OR SELECT A NEW ONE</h3>
    <form:input path="password" />
    <br>

    <form:label path="birthDate"><h3>Birthday:</h3></form:label>
    <br>
    <form:input path="birthDate" />

    <form:hidden path="userType" />
    <form:hidden path="id" />

    <br><br>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" class="btn btn-success" value="Save Changes">

</form:form>

<form method="GET" name="logout" action="./homepage">
        <input type="submit" class="btn btn-primary" value="Cancel">
</form>


</body>
</html>
