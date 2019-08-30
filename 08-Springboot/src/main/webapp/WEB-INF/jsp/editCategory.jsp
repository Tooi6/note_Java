<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/29
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改Category</title>
</head>
<body>
    <div style="margin: 0px auto;width: 500px;">
        <form action="updateCategory" method="post">
            name:<input name="name" value="${c.name}">
            <input type="hidden" name="id" value="${c.id}">
            <button type="submit">提交</button>
        </form>
    </div>
</body>
</html>
