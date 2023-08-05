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
    <title>Display list book</title>
</head>
<body>
<h1>List book</h1>
<a href="/book?action=create">create</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Category</th>
        <th></th>
        <c:forEach items ="${books}" var="book">
            <tr>
    <td>${book.id}</td>
    <td>${book.name}</td>
    <td>${book.author}</td>
    <td>${book.category.name}</td>
    <td><a href="/book?action=edit&id=${book.id}">edit</a></td>
            </tr>
        </c:forEach>
    </tr>
</table>
</body>
</html>
