<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/product">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>"${requestScope["product"].getNameProduct()}"</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>"${requestScope["product"].getPrice()}"</td>
            </tr>
            <tr>
                <td>Image: </td>
                <td>"${requestScope["product"].getImage()}"</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/produtc">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>