<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Product Discount Calculator" %>
</h1>
<br/>
<p>Nhập thông tin về sản phẩm</p>
<form action="/DiscountServlet">
    <input type="text" name="description" placeholder="Product description"/><br/>
    <input type="text" name="price" placeholder="List price"/><br/>
    <input type="text" name="discount-percent" placeholder="Discount percent"/><br/>
    <input type="submit" name="calculate" value="CALCULATE">
</form>
</body>
</html>