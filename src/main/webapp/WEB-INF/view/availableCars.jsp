<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Car selection</title>
</head>
<body>

<div class="jumbotron">
<h3>Please select the vehicle you'd look to book from the list below:</h3>

</div>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="submit" class="btn btn-primary" value="Cancel">
</form>
<br>
<form action="./saveOrUpdateBook" method="POST">

    <input type="hidden" name="startDate" value="${startDate}"/>
    <input type="hidden" name="endDate" value="${endDate}"/>
    <input type="hidden" name="userID" value="${userID}"/>
    <input type="hidden" name="bookID" value="${bookID}"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<table class="table table-bordered table-striped table-condensed">
    <tr>
        <th>
            Car
        </th>
        <th>
            Model
        </th>
        <th>
            Color
        </th>
        <th>
            Book
        </th>
    </tr>

    <c:forEach items="${carList}" var="car">
        <tr>
            <td>
                    ${car.brand}
            </td>
            <td>
                    ${car.model}
            </td>
            <td>
                    ${car.color}
            </td>
            <td>
                <input type="hidden" name="carID" value="${car.id}"/>
                <input type="submit" class="btn btn-success" value="<-- Book This Vehicle"/>
            </td>
        </tr>
    </c:forEach>
</table>
</form>

</body>
</html>
