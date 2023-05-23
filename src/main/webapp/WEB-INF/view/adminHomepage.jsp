<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Admin Homepage</title>
</head>
<body>
<div class="jumbotron text-center">
    <h2>Welcome Admin:
        <br>
        ${user.firstName} ${user.lastName}</h2>
</div>
<br><br>

<div class="container">
    <div class="row">
        <div class="col-sm">
            <p text-center>
            <h3>User Functions:</h3></p>
            <form method="GET" action="./profile">
                <input type="hidden" name="userID" value="${user.id}"/>
                <input type="submit" class="btn btn-info" value="See Your Profile Info">
            </form>

            <form method="GET" action="/SpringMVCPJ_war_exploded/book/bookList">
                <input type="hidden" name="userID" value="${user.id}"/>
                <input type="submit" class="btn btn-info" value="View Your Bookings">
            </form>

            <form method="GET" name="logout" action="./logout">
                <input type="submit" class="btn btn-warning" value="Log Out">
            </form>
        </div>

        <br>

        <div class="col-sm">
            <p text-center>
            <h3>Admin Functions:</h3></p>
            <table>
                <tr>
                    <td>
                        <form action="./addUser" method="GET">
                            <input type="hidden" name="userID" value="${user.id}"/>
                            <input type="submit" class="btn btn-primary" value="Register New User">
                        </form>
                    </td>
                    <td>
                        <form action="/SpringMVCPJ_war_exploded/car/addCar" method="GET">
                            <input type="hidden" name="userID" value="${user.id}"/>
                            <input type="submit" class="btn btn-primary" value="Register New Car">
                        </form>
                    </td>
                    <td>
                        <form action="/SpringMVCPJ_war_exploded/book/addBook" method="GET">
                            <input type="hidden" name="userID" value="${user.id}"/>
                            <input type="submit" class="btn btn-primary" value="Make a new Booking">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form action="./userList" method="GET">
                            <input type="hidden" name="userID" value="${user.id}"/>
                            <input type="submit" class="btn btn-info" value="View User List">
                        </form>
                    </td>
                    <td>
                        <form action="/SpringMVCPJ_war_exploded/car/carList" method="GET">
                            <input type="hidden" name="userID" value="${user.id}"/>
                            <input type="submit" class="btn btn-info" value="View Car List">
                        </form>
                    </td>
                    <td>
                        <form action="/SpringMVCPJ_war_exploded/book/globalBookList" method="GET">
                            <input type="hidden" name="userID" value="${user.id}"/>
                            <input type="submit" class="btn btn-info" value="View Booking List">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
