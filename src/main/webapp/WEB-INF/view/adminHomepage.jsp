<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Homepage</title>
</head>
<body>
<h2>Welcome Admin: ${user.firstName} ${user.lastName}</h2>

<br><br>

<form method="GET" name="profile" action="./profile">
    <input type="hidden" name="userID" value="${user.id}"/>
    <input type="submit" value="See Your Profile Info">
</form>

<form method="GET" name="logout" action="/SpringMVCPJ_war_exploded/book/bookList">
    <input type="hidden" name="userID" value="${user.id}"/>
    <input type="submit" value="View Your Bookings">
</form>

<form method="GET" name="logout" action="./logout">
    <input type="submit" value="Log Out">
</form>

<br>

<h3>Admin Functions:</h3>
<table >
    <tr>
        <td>
            <form action="./addUser" method="GET">
                <input type="hidden" name="userID" value="${user.id}"/>
                <input type="submit" value="Register New User">
            </form>
        </td>
        <td>
            <form action="user" method="GET">
                <input type="hidden" name="command" value="addPage" />
                <input type="hidden" name="userID" value="${user.id}" />
                <input type="hidden" name="object" value="car" />
                <input type="submit" value="Register New Car">
            </form>
        </td>
        <td>
            <form action="/SpringMVCPJ_war_exploded/book/addBook" method="GET">
                <input type="hidden" name="userID" value="${user.id}" />
                <input type="submit" value="Make a new Booking">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="./userList" method="GET">
                <input type="hidden" name="userID" value="${user.id}" />
                <input type="submit" value="View User List">
            </form>
        </td>
        <td>
            <form action="car" method="GET">
                <input type="hidden" name="command" value="carList" />
                <input type="hidden" name="userID" value="${user.id}" />
                <input type="submit" value="View Car List">
            </form>
        </td>
        <td>
            <form action="book" method="GET">
                <input type="hidden" name="command" value="bookList" />
                <input type="hidden" name="userID" value="${user.id}" />
                <input type="submit" value="View Booking List">
            </form>
        </td>
    </tr>
</table>

</body>
</html>
