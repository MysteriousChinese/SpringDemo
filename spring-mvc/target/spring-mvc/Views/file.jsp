<%--
  Created by IntelliJ IDEA.
  User: gqx
  Date: 2021/5/6
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/file/upload" enctype="multipart/form-data">
    文件名称:<input type="text" name="fileName"/><br>
    选择文件:<input type="file" name="fileInfo"/><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
