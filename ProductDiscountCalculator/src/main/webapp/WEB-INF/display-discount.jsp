<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Black Pig
  Date: 06-May-24
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Mô tả sản phẩm: ${description}</p>
<p>Giá sản phẩm niêm yết: ${price}</p>
<p>Tỷ lệ chiết khấu: ${discountPercent}</p>
<p>Lượng chiết khấu: ${discountAmount}</p>
<p>Giá sau chiết khấu: ${discountPrice}</p>
</body>
</html>
