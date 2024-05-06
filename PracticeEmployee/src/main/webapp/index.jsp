<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Employee Management" %>
</h1>
<br/>
<a href="/EmployeeServlet?action=LIST">Danh sách nhân viên</a>
<br>
<a href="/EmployeeServlet?action=ADD">Thêm nhân viên mới</a>
</body>
</html>