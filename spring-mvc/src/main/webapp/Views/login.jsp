<%--
  Created by IntelliJ IDEA.
  User: gqx
  Date: 2021/5/12
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login/login" method="post">
    <fieldset style="text-align: center">
        <legend>登录</legend>
        <p>用户: <input type="text" name="ID" /></p>
        <p>密码: <input type="text" name="password" /></p>
        <input type="submit" value="提交">
    </fieldset>
</form>
</body>
</html>
