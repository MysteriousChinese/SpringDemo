<%--
  Created by IntelliJ IDEA.
  User: gqx
  Date: 2021/4/11
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HELLO</title>
    <base href="${pageContext.request.contextPath}"/>
    <link href="/static/css/main.css" rel="stylesheet" type="text/css"/>
    <script src="/static/js/main.js" type="text/javascript"></script>
</head>
<body>
Spring-MVC
<hr>
<input type="button" value="${name}" onclick="btnClick(this);" />
</body>
</html>
