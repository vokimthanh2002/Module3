<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/11/2022
  Time: 8:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book/list.jsp" method="post">
  <table border="1">
    <tr>
      <td>ID</td>
      <td><input type="text" name="id" value="${book.id}"></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name" value="${book.name}"></td>
    </tr>

    <tr>
      <td>Author</td>
      <td><input type="text" name="author" value="${book.author}"></td>
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
      <td><input type="reset" value="Reset"></td>
      <input type="hidden" name="action" value="edit">
    </tr>
  </table>
</form>
</body>
</html>
