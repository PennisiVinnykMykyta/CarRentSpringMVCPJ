<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Add Booking</title>
</head>
<body>
Please select the date:

${error}

<form action="./selectCar" method="POST">
    Start Date:
    <input type="date" name="startDate"  />
    <br><br>
    End Date:
    <input type="date" name="endDate" />
    <br><br>
    <input type="hidden" name="userID"  value="${user.id}">
    <input type="hidden" name="bookID"  value="${bookID}">
    <input type="submit" value="Continue">
</form>

<form method="GET" name="revert" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="password" value="${user.password}">
    <input type="submit" value="Cancel">
</form>

</body>
</html>
