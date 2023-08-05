<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23/11/2022
  Time: 8:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new book</title>
</head>
<body>
<h1>Create new book</h1>
<form action="/book" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>Author</td>
            <td><input type="text" name="author"></td>
        </tr>

        <tr>
            <td>Category</td>
            <td>
                <select name="categoryId">
                    <c:forEach items="${categories}" var ="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
            <td><input type="reset" value="Reset    "></td>
            <input type="hidden" name="action" value="create">
        </tr>
    </table>
</form>
</body>
</html>
