<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/19
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list.jsp</title>
</head>
<body>
<table align="center" border="1" cellspacing="0" width="500px">
    <a href="listProduct">listProduct</a>
    <br/>
    <a href="listCategory">listCategory</a>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>productList</td>
        <td>edit</td>
        <td>delete</td>
    </tr>

    <s:iterator value="categoryList" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td><a href="listProduct?category.id=${c.id}">productList</a></td>
            <td><a href="editCategory?category.id=${c.id}">edit</a></td>
            <td><a href="deleteCategory?category.id=${c.id}">delete</a></td>
        </tr>
    </s:iterator>
</table>

<br/>

<form action="addCategory" method="post">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>
                name:
            </td>
            <td>
                <input type="text" name="category.name" value="">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
