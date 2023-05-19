<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Customer HomePage</title>
</head>
<body>
<h2>Welcome Customer: ${user.firstName} ${user.lastName}</h2>

<br><br>
<table>
    <tr>
        <form method="GET" action="./profile">
            <input type="hidden" name="userID" value="${user.id}"/>
            <input type="submit" value="See Your Profile Info">
        </form>
    </tr>
    <tr>
        <form method="GET" action="/SpringMVCPJ_war_exploded/book/addBook">
            <input type="hidden" name="userID" value="${user.id}"/>
            <input type="submit" value="Make a New Booking">
        </form>
    </tr>
    <tr>
        <form method="GET" action="./logout">
            <input type="submit" value="Log Out">
        </form>
    </tr>
</table>

<table border="1px">
    <tr>
        <th>
            Booking Number
        </th>
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
            Number plate
        </th>
        <th>
            Starting Date
        </th>
        <th>
            Drop-Off Date
        </th>
        <th>
            Confirmation
        </th>
        <th>
            Options
        </th>
    </tr>

    <c:forEach items="${user.bookList}" var="book">
        <tr>
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
                    <input type="submit" value="Modify Booking">
                </form>

                <form action="/SpringMVCPJ_war_exploded/book/deleteLocal" method="POST">
                    <input type="hidden" name="userID" value="${user.id}" />
                    <input type="hidden" name="deleteID" value="${book.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Delete Booking">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<br><br>

</body>
</html>
