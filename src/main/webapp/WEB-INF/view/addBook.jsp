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
    <input type="hidden" name="bookID"  value="${bookID}">
    <input type="hidden" name="userID"  value="${userID}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Continue">
</form>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="submit" value="Cancel">
</form>

</body>
</html>
