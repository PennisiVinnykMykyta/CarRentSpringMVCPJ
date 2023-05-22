<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Car</title>
</head>
<body>

<h3>Compile the form below to add a new car to the list:</h3>

<form:form action="/SpringMVCPJ_war_exploded/car/addOrChangeCar" method="POST" modelAttribute="car">
    <form:hidden path="id" value=""/>

    Model: <form:input path="model" />
    <br><br>
    Brand: <form:input path="brand" />
    <br><br>
    Color: <form:input path="color" />
    <br><br>
    NumberPlate: <form:input path="numberPlate" />
    <br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Add New Car"/>

</form:form>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage" >
    <input type="submit" value="Cancel" />
</form>

</body>
</html>
