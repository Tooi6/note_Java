<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/28
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误界面</title>
</head>
<body>
    <div style="width:500px;border:1px solid lightgray;margin:200px auto;padding:80px">
        系统 出现异常，异常原因是：
        ${exception}
        <br/>
        出现异常的地址是：
        ${url}
    </div>
</body>
</html>
