<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/30
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">
        // 将 post method改成delete
        $(function () {
            $(".delete").click(function () {
                var href=$(this).attr("href");
                $("#formdelete").attr("action",href).submit();
                return false;
            })
        })
    </script>
</head>
<body>
    <div style="text-align: center;width: 500px;margin: 20px">
        <table align="center" border="1" cellspacing="0">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>编辑</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${page.content}" var="c" varStatus="st">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><a href="categories/${c.id}">编辑</a></td>
                    <td><a class="delete" href="categories/${c.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <div>
            <a href="?start=0">[首 页]</a>
            <a href="?start=${page.number-1}">[上一页]</a>
            <a href="?start=${page.number+1}">[下一页]</a>
            <a href="?start=${page.totalPages-1}">[末 页]</a>
        </div>
        <br/>
        <form action="categories" method="post">
            name:<input name="name"/><br/>
            <input type="submit" value="提交">
        </form>
        <form id="formdelete" action="" method="post">
            <input type="hidden" name="_method" value="DELETE">
        </form>
    </div>
</body>
</html>
