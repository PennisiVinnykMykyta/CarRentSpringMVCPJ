<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Car selection</title>
</head>
<body>

<form method="GET" name="revert" action="/SpringMVCPJ_war_exploded/user/homepage">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="password" value="${user.password}">
    <input type="submit" value="Cancel">
</form>

<h3>Please select the vehicle you'd look to book from the list below:</h3>
<table border="1px">
    <tr>
        <th>
            Model
        </th>
        <th>
            Brand
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
                    ${car.model}
            </td>
            <td>
                    ${car.brand}
            </td>
            <td>
                    ${car.color}
            </td>
            <td>
                <form action="./saveOrUpdateBook" method="POST">
                    <input type="hidden" name="startDate" value="${startDate}"/>
                    <input type="hidden" name="endDate" value="${endDate}"/>
                    <input type="hidden" name="carID" value="${car.id}"/>
                    <input type="hidden" name="userID" value="${user.id}"/>
                    <input type="hidden" name="bookID" value="NO"/>
                    <input type="submit" value="<-- Book This Vehicle"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
