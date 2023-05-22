<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>

<form:form method="POST" action="/SpringMVCPJ_war_exploded/user/save" modelAttribute="userToChange">

    First Name:
    <form:input path="firstName" />
    <br><br>

    Last Name:
    <form:input path="lastName" />
    <br><br>

    Email:
    <form:input path="email" />
    <br><br>

    Password:
    <form:input path="password" />
    <br><br>

    Birthday:
    <form:input path="birthDate" />
    <br><br>

     Type of user:
    <br>
    <form:radiobutton path="userType" value="admin" />Admin
    <br>
    <form:radiobutton path="userType" value="customer"  />Customer
    <br><br>

    <form:hidden path="id" value = ""/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Save Changes">
</form:form>

<form method="GET" action="./homepage">
    <input type="submit" value="Cancel">
</form>

</table>


</body>
</html>
