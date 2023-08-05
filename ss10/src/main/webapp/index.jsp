<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<table border="1">
<tr>
    <th>Ten</th>
    <th>Ngay Sinh</th>
    <th>Dia Chi</th>
    <th>Anh</th>
</tr>
        <c:forEach items="${customer}"  var ="customer">
            <tr>
                <td>${customer.ten}</td>
                <td>${customer.ngaySinh}</td>
                <td>${customer.diaChi}</td>
                <td><img src="./image/ma.jpg"/>
                </td>
            </tr>
        </c:forEach>
</table>
</body>
</html>