<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Change Car</title>
</head>
<body>

<form method="GET" name="logout" action="/SpringMVCPJ_war_exploded/user/homepage">
  <input type="hidden" name="email" value="${user.email}">
  <input type="hidden" name="password" value="${user.password}" >
  <input type="submit" value="Cancel">
</form>

<br><br>

<form action="./addOrChangeCar" method="POST">

  Model: <input type="text" name="model"  value="${car.model}">
  <br>
  Brand: <input type="text" name="brand" value="${car.brand}">
  <br>
  Color: <input type="text" name="color" value="${car.color}">
  <br>
  Plate Number: <input type="text" name="plate" value="${car.numberPlate}">
  <br>
  <input type="hidden" name="carID" value="${car.id}" />
  <input type="hidden" name="userID" value="${user.id}" />
  <input type="submit" value="Submit" />
</form>
<br>

</body>
</html>
