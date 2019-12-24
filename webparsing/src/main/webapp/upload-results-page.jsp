<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<body>
<h1>${sessionScope.valid}</h1>
<table border="1">
    <caption>Result of parsing</caption>
    <tr>
        <th>Name</th>
        <th>Energy</th>
        <th>Type</th>
        <th>Water</th>
        <th>Sugar</th>
        <th>Fructose</th>
        <th>Vanillin</th>
        <th>Proteins</th>
        <th>Fats</th>
        <th>Carbohydrates</th>
        <th>Production</th>
        <th>Chocolate Type</th>
    </tr>
    <c:forEach items="${sessionScope.sweets}" var="sweet">
        <tr>
            <td style="text-align:center">${sweet.name}</td>
            <td style="text-align:center">${sweet.energy}</td>
            <td style="text-align:center">${sweet.type}</td>
            <td style="text-align:center">${sweet.waterAmount}</td>
            <td style="text-align:center">${sweet.sugarAmount}</td>
            <td style="text-align:center">${sweet.fructoseAmount}</td>
            <td style="text-align:center">${sweet.vanillinAmount}</td>
            <td style="text-align: center">${sweet.proteins}</td>
            <td style="text-align: center">${sweet.fats}</td>
            <td style="text-align: center">${sweet.carbohydrates}</td>
            <td style="text-align:center">${sweet.production}</td>
            <td style="text-align:center">${sweet.chocolateType}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
