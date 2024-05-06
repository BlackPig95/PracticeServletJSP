<%--
  Created by IntelliJ IDEA.
  User: Black Pig
  Date: 06-May-24
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm nhân viên mới</h1>
<form action="/EmployeeServlet" method="post" enctype="multipart/form-data">
    <label>Tên nhân viên: <input type="text" name="name" placeholder="Tên nhân viên..."/> </label><br/>
    <label>Ngày sinh: <input type="date" name="dob"/> </label><br/>
    <label>Giới tính:
        <input type="radio" checked name="sex" value="true"/><span>Nam</span>
        <input type="radio" name="sex" value="false"/><span>Nữ</span>
    </label><br/>
    <label>Ảnh đại diện: <input type="file" name="avatar"/> </label><br/>
    <input type="submit" name="action" value="ADD"/><br/>
</form>
</body>
</html>
