<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
    <label>Product Description </label><br/>
    <input type="text" name="description" placeholder="Product Description" /><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="List Price" /><br/>
    <label>Discount Percent </label><br/>
    <input type="text" name="percent" placeholder="Discount Percent" /><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>