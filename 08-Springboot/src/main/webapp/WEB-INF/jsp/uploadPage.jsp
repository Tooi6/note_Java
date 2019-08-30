<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/30
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        选择图片：<input type="file" name="file" accept="image/*"/> <br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
