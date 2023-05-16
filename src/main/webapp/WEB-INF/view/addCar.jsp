<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Car</title>
</head>
<body>

<h3>Compile the form below to add a new car to the list:</h3>

<form action="./addOrChangeCar" method="POST">
    <input type="hidden" name="userID" value="${user.id}" />
    <input type="hidden" name="carID" />

    Model: <input type = "text" name="model" />
    <br><br>
    Brand: <input type = "text" name="brand" />
    <br><br>
    Color: <input type = "text" name="color" />
    <br><br>
    NumberPlate: <input type = "text" name="plate" />
    <br><br>
    <input type="submit" value="Add New Car"/>

</form>

<form method="GET" name="revert" action="/SpringMVCPJ_war_exploded/user/homepage" >
    <input type="hidden" name="email" value="${user.email}" />
    <input type="hidden" name="password" value="${user.password}" />
    <input type="submit" value="Cancel" />
</form>

</body>
</html>
