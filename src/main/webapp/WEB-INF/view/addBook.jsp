<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Add Booking</title>
</head>
<body>
<div class="jumbotron">
<h2>Please select the date:</h2>
<br>

<h2>${error}</h2>
</div>

<form action="./selectCar" method="POST">
    <h3>Start Date:</h3>
    <input type="date" name="startDate"  />
    <br><br>
    <h3>End Date:</h3>
    <input type="date" name="endDate" />
    <br><br>
    <input type="hidden" name="bookID"  value="${bookID}">
    <input type="hidden" name="userID"  value="${userID}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" class="btn btn-success" value="Continue">
</form>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="submit" class="btn btn-primary" value="Cancel">
</form>

</body>
</html>
