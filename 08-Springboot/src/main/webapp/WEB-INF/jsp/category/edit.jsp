<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/30
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
    <div style="margin: 0px auto;width: 500px">
        <form action="${c.id}" method="post">
            <input type="hidden" name="_method" value="PUT">
            name：<input name="name" value="${c.name}"><br/>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
