<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>User List</title>
</head>
<body>

<div class="jumbotron text-center">
    <h2>List of all the Users</h2>
</div>
<br>
<form method="GET" action="./homepage">
    <input type="submit" class="btn btn-primary" value="Go Back">
</form>
<br>
<table class="table table-bordered table-striped table-condensed">
    <tr class="info">
        <th>
            <p class="text-center">First Name</p>
        </th>
        <th>
            <p class="text-center">Last Name</p>
        </th>
        <th>
            <p class="text-center">Email</p>
        </th>
        <th>
            <p class="text-center">BirthDate</p>
        </th>
        <th>
            <p class="text-center">UserType</p>
        </th>
        <th>
            <p class="text-center">Options</p>
        </th>
    </tr>

    <c:forEach items="${userList}" var="userEntity">
        <tr class="text-center">
            <td>
                    ${userEntity.firstName}
            </td>
            <td>
                    ${userEntity.lastName}
            </td>
            <td>
                    ${userEntity.email}
            </td>
            <td>
                    ${userEntity.birthDate}
            </td>
            <td>
                    ${userEntity.userType}
            </td>
            <td>
                <form action="./changeProfile" method="POST">
                    <input type="hidden" name="userToChangeID" value="${userEntity.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-info" value="Modify User">
                </form>

                <form action="./deleteUser" method="POST">
                    <input type="hidden" name="deleteID" value="${userEntity.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Delete User">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
