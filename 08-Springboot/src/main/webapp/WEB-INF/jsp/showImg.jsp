<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/30
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示图片</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}/uploaded/${fileName}">
</body>
</html>
