<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>Danh sách nhân viên</h1>
<a href="/EmployeeServlet?action=ADD">Thêm nhân viên mới</a>
<table border="1" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>Id</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Ảnh</th>
        <th colspan="2">Thao tác quản lý</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="employee" varStatus="loopStatus">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.dob}</td>
            <td>${employee.sex?"Nam":"Nữ"}</td>
            <td><img src="<%=request.getContextPath()%>${employee.avatar}" alt="Ảnh" width="100" height="100"
                     style="object-fit: cover"/></td>
            <td><a href="">Sửa</a></td>
            <td><a href="">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
