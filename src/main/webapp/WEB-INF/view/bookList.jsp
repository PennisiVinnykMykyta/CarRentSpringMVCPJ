<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Your Bookings</title>
</head>
<body>

<form method="GET" name="logout" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="password" value="${user.password}" >
    <input type="submit" value="Go Back">
</form>

<table border="1px">
    <tr>
        <th>
            Booking ID
        </th>
        <th>
            User
        </th>
        <th>
            Car
        </th>
        <th>
            StartDate
        </th>
        <th>
            Drop-Off Date
        </th>
        <th>
            Conformation
        </th>
        <th>
            Options
        </th>
    </tr>

    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>
                    ${book.id}
            </td>
            <td>
                    ${book.user.email}
            </td>
            <td>
                    ${book.car.model} ${book.car.brand} ${book.car.color}
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
                <form action="book" method="POST"> // modify
                    <input type="hidden" name="userID" value="${user.id}"/>
                    <input type="hidden" name="bookID" value="${book.id}">
                    <input type="submit" value="Modify Booking">
                </form>

                <form action="book" method="POST"> //delete
                    <input type="hidden" name="userID" value="${user.id}"/>
                    <input type="hidden" name="deleteID" value="${book.id}">
                    <input type="submit" value="Delete Booking">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>