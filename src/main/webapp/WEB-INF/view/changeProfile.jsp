<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Change Profile</title>
</head>
<body>

<form:form method="POST" action="/SpringMVCPJ_war_exploded/user/save" modelAttribute="userToChange">

    <form:label path="firstName">First Name:</form:label>
    <form:input path="firstName" />
    <br><br>

    <form:label path="lastName">Last Name:</form:label>
    <form:input path="lastName" />
    <br><br>

    <form:label path="email">Email:</form:label>
    <form:input path="email" />
    <br><br>

    Password: RE-INSERT YOUR PASSWORD OR SELECT A NEW ONE
    <br>
    <form:input path="password" />
    <br><br>

    <form:label path="birthDate">Birthday:</form:label>
    <form:input path="birthDate" />

    <form:hidden path="userType" />
    <form:hidden path="id" />

    <br><br>

    <input type="hidden" name ="userID" value="${user.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Save Changes">

</form:form>

<form method="GET" name="logout" action="./homepage">
        <input type="submit" value="Cancel">
</form>


</body>
</html>
