<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Change Car</title>
</head>
<body>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
  <input type="submit" value="Cancel">
</form>

<br><br>

<form:form action="./addOrChangeCar" method="POST" modelAttribute="car">

  <form:label path="model">Model:</form:label>
  <form:input path="model" />
  <br>
  <form:label path="brand">Brand:</form:label>
  <form:input path="brand" />
  <br>
  <form:label path="color">Color:</form:label>
  <form:input path="color" />
  <br>
  <form:label path="numberPlate">NumberPlate:</form:label>
  <form:input path="numberPlate" />
  <br>
  <form:hidden path="id" />

  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <input type="submit" value="Submit" />
</form:form>
<br>

</body>
</html>
