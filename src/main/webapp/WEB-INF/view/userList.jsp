<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h3>List of all the Users</h3>

<form method="GET" name="logout" action="./homepage">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="password" value="${user.password}" >
    <input type="submit" value="Go Back">
</form>
<br><br>
<table border="1px">
    <tr>
        <th>
            First Name
        </th>
        <th>
            Last Name
        </th>
        <th>
            Email
        </th>
        <th>
            BirthDate
        </th>
        <th>
            UserType
        </th>
        <th>
            Options
        </th>
    </tr>

    <c:forEach items="${userList}" var="userEntity">
        <tr>
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
                    <input type="hidden" name="userID" value="${user.id}" />
                    <input type="hidden" name="userToChangeID" value="${userEntity.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Modify User">
                </form>

                <form action="./deleteUser" method="POST">
                    <input type="hidden" name="userID" value="${user.id}" />
                    <input type="hidden" name="deleteID" value="${userEntity.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Delete User">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
