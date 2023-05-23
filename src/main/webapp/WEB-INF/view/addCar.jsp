<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Add Car</title>
</head>
<body>
<div class="jumbotron">
<h2>Compile the form below to add a new car to the list:</h2>
</div>

<form:form action="/SpringMVCPJ_war_exploded/car/addOrChangeCar" method="POST" modelAttribute="car">
    <form:hidden path="id" value=""/>

    <h3>Model:</h3> <form:input path="model" />
    <br><br>
    <h3>Brand:</h3> <form:input path="brand" />
    <br><br>
    <h3>Color:</h3> <form:input path="color" />
    <br><br>
    <h3>NumberPlate:</h3> <form:input path="numberPlate" />
    <br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit"  class="btn btn-success" value="Add New Car"/>

</form:form>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage" >
    <input type="submit"  class="btn btn-primary" value="Cancel" />
</form>

</body>
</html>
