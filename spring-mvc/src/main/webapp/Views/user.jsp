<%--
  Created by IntelliJ IDEA.
  User: gqx
  Date: 2021/4/15
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/receiveArray" method="post">
    <c:forEach items="${userList}" var="user">
        用户:<input type="text" name="name" value="${user.name}"></br>
        年龄:<input type="text" name="age" value="${user.age}"></br>
    </c:forEach>
       <%--年龄:<input type="text" name="ID" value="${userList[0].id}"></br>
       用户:<input type="text" name="name" value="${userList[0].name}"></br>
       年龄:<input type="text" name="age" value="${userList[0].age}"></br>--%>
    <input type="submit" value="提交">
</form>

</body>
</html>
