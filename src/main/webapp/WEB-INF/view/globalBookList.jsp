<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>All Bookings</title>
</head>
<body>

<div class="jumbotron text-center">
    <h2>List of all the Bookings</h2>
</div>

<form method="GET" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="submit" class="btn btn-primary" value="Go Back">
</form>

<table class="table table-bordered table-striped table-condensed ">
    <tr class="info">
        <th>
            <p class="text-center">Booking ID</p>
        </th>
        <th>
            <p class="text-center">User</p>
        </th>
        <th>
            <p class="text-center">Car</p>
        </th>
        <th>
            <p class="text-center">StartDate</p>
        </th>
        <th>
            <p class="text-center">Drop-Off Date</p>
        </th>
        <th>
            <p class="text-center">Conformation</p>
        </th>
        <th>
            <p class="text-center">Options</p>
        </th>
    </tr>

    <c:forEach items="${bookList}" var="book">
        <tr class="text-center">
            <td>
                    ${book.id}
            </td>
            <td>
                    ${book.user.email}
            </td>
            <td>
                    ${book.car.brand} ${book.car.model} ${book.car.color}
            </td>
            <td>
                    ${book.startDate}
            </td>
            <td>
                    ${book.endDate}
            </td>
            <td>
                    ${book.valid}
            </td>
            <td>
                <form action="./acceptBooking" method="POST">
                    <input type="hidden" name="bookID" value="${book.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-success" value="Accept Booking">
                </form>

                <form action="./deleteGlobal" method="POST">
                    <input type="hidden" name="deleteID" value="${book.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Decline Booking">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
