<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 09/02/2023
  Time: 9:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Image: </td>
                <td><input type="text" name="image" id="image" value="${requestScope["product"].getImage()}"></td>
                <td><<img src="${requestScope["product"].getImage()}"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
