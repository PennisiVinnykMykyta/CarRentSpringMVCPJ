<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Change Car</title>
</head>
<body>

<form:form action="./addOrChangeCar" method="POST" modelAttribute="car">

  <form:label path="model"><h3>Model:</h3></form:label>
  <form:input path="model" />
  <br>
  <form:label path="brand"><h3>Brand:</h3></form:label>
  <form:input path="brand" />
  <br>
  <form:label path="color"><h3>Color:</h3></form:label>
  <form:input path="color" />
  <br>
  <form:label path="numberPlate"><h3>NumberPlate:</h3></form:label>
  <form:input path="numberPlate" />
  <br>
  <form:hidden path="id" />

  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <input type="submit" class="btn btn-success" value="Submit" />
</form:form>
<br>
<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
  <input type="submit" class="btn btn-primary" value="Cancel">
</form>

</body>
</html>
