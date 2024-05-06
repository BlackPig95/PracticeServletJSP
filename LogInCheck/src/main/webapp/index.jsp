<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/hello-servlet" method="post">
    <input type="text" name="username" placeholder="Input your username"/>
    <input type="password" name="password" placeholder="Input your password"/>
    <input type="submit" name="login" value="Log in"/>
</form>
<p>${failed}</p>
</body>
</html>