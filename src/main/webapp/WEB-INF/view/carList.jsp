<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Car List</title>
</head>

<body>

<div class="jumbotron text-center">
    <h2>List of all the Cars</h2>
</div>
<br>
<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="submit" class="btn btn-primary" value="Go Back">
</form>
<br>

<table class="table table-bordered table-striped table-condensed ">
    <tr  class="info">
        <th>
            <p class="text-center">Car Number</p>
        </th>
        <th>
            <p class="text-center">Brand</p>
        </th>
        <th>
            <p class="text-center">Model</p>
        </th>
        <th>
            <p class="text-center">Color</p>
        </th>
        <th>
            <p class="text-center">Number Plate</p>
        </th>
        <th>
            <p class="text-center">Options</p>
        </th>
    </tr>

    <c:forEach items="${carList}" var="car">
        <tr class ="text-center">
            <td>
                    ${car.id}
            </td>
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
                    ${car.numberPlate}
            </td>
            <td>
                <form action="./changeCar" method="GET">
                    <input type="hidden" name="carID" value="${car.id}">
                    <input type="submit" class="btn btn-info" value="Modify Car">
                </form>

                <form action="./delete" method="POST">
                    <input type="hidden" name="deleteID" value="${car.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Delete Car">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
