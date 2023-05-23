<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Customer HomePage</title>
</head>
<body>
<div class="jumbotron text-center">
<h2>Welcome Customer: <br> ${user.firstName} ${user.lastName}</h2>
</div>

<br><br>
<table>
    <tr>
        <form method="GET" action="./profile">
            <input type="hidden" name="userID" value="${user.id}"/>
            <input type="submit" class="btn btn-info" value="See Your Profile Info">
        </form>
    </tr>
    <tr>
        <form method="GET" action="/SpringMVCPJ_war_exploded/book/addBook">
            <input type="hidden" name="userID" value="${user.id}"/>
            <input type="submit" class="btn btn-primary" value="Make a New Booking">
        </form>
    </tr>
    <tr>
        <form method="GET" action="./logout">
            <input type="submit" class="btn btn-warning" value="Log Out">
        </form>
    </tr>
</table>
<br>

<table class="table table-bordered table-striped table-condensed">
    <tr class="info">
        <th>
            <p class="text-center">Booking Number</p>
        </th>
        <th>
            <p class="text-center">Car</p>
        </th>
        <th>
            <p class="text-center">Model</p>
        </th>
        <th>
            <p class="text-center">Color</p>
        </th>
        <th>
            <p class="text-center">Number plate</p>
        </th>
        <th>
            <p class="text-center">Starting Date</p>
        </th>
        <th>
            <p class="text-center">Drop-Off Date</p>
        </th>
        <th>
            <p class="text-center">Confirmation</p>
        </th>
        <th>
            <p class="text-center">Options</p>
        </th>
    </tr>

    <c:forEach items="${user.bookList}" var="book">
        <tr class="text-center">
            <td>
                    ${book.id}
            </td>
            <td>
                    ${book.car.brand}
            </td>
            <td>
                    ${book.car.model}
            </td>
            <td>
                    ${book.car.color}
            </td>
            <td>
                    ${book.car.numberPlate}
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
                <form action="/SpringMVCPJ_war_exploded/book/addBook" method="GET">
                    <input type="hidden" name="command" value="addOrChangeBooking"/>
                    <input type="hidden" name="userID" value="${user.id}"/>
                    <input type="hidden" name="bookID" value="${book.id}">
                    <input type="submit" class="btn btn-info" value="Modify Booking">
                </form>

                <form action="/SpringMVCPJ_war_exploded/book/deleteLocal" method="POST">
                    <input type="hidden" name="userID" value="${user.id}" />
                    <input type="hidden" name="deleteID" value="${book.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Delete Booking">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<br><br>

</body>
</html>
