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
<h1>Nhập thông tin mới</h1>
<c:choose>
    <c:when test="${edit == null}">
        <h2 style="color: red">Không tìm thấy nhân viên</h2>
        <a href="/index.jsp">Quay lại trang chủ</a>
    </c:when>
    <c:otherwise>
        <form action="/EmployeeServlet" method="post" enctype="multipart/form-data">
            <input type="number" name="id" value="${edit.id}" style="display: none"/>
            <label>Tên nhân viên: <input type="text" name="name" value="${edit.name}"/> </label><br/>
            <label>Ngày sinh: <input type="date" name="dob" value="${edit.dob}"/> </label><br/>
            <label>Giới tính:
                <input type="radio" ${edit.sex?"checked":""} name="sex" value="true"/><span>Nam</span>
                <input type="radio" ${edit.sex?"":"checked"} name="sex" value="false"/><span>Nữ</span>
            </label><br/>
            <label>Ảnh đại diện: <input type="file" name="avatar"/></label><br/>
            <input type="submit" name="action" value="EDIT"/><br/>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
