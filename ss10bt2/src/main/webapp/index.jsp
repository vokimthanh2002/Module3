<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculator" method="post" >
    <label>First operand: </label><br/>
    <input type="text" name="num1" placeholder="First operand" value="231"/><br/>
    <label>Operator: </label><br/>
    <select name="op">
        <option value="1">Cong</option>
        <option value="2">Tru</option>
        <option value="3">Nhan</option>
        <option value="4">Chia</option>
    </select>
    <br>
    <label>Second operand: </label><br/>
    <input type="text" name="num2" placeholder="Second operand" value="231"/><br/>
    <input type="submit" value="Calculator">
</form>
</body>
</html>