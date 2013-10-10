<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" href="<c:url value="/css/main.css" />"/>
</head>
<body>
    <h2>Products</h2>
    <ul class="list">
        <c:forEach var="product" items="${shop.products}">
        <li>
            <form action="<c:url value="/cart" />" method="post">
                <c:out value="${product.name}"/>
                <input type="hidden" name="productName" value="<c:out value="${product.name}"/>"/>
                <input type="submit" value="add to cart"/>
            </form>
        </li>
        </c:forEach>
    </ul>
    <c:if test="${not empty cart}">
        <hr>
        <h2>Shopping cart</h2>
        <ul class="list">
            <c:forEach var="item" items="${cart.items}">
                <li><c:out value="${item.quantity}"/> x <c:out value="${item.product.name}"/></li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
