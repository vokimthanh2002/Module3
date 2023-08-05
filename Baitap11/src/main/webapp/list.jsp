<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/product?action=create">Create new customer</a><br>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Image</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${product}' var="product">
        <tr>
            <td><a href="/product?action=view&id=${product.getIdProduct()}">${product.getNameProduct()}</a></td>
            <td>${product.getPrice()}</td>
            <td style="padding: 50px"><img style="height: 100px" src="${product.image}"/>
            </td>
            <td><a href="/product?action=edit&id=${product.getIdProduct()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getIdProduct()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>