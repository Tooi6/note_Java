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
        <td>price</td>
        <td>category</td>
        <td>edit</td>
        <td>delete</td>
    </tr>

    <s:iterator value="productList" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.category.name}</td>
            <td><a href="editProduct?product.id=${p.id}">edit</a></td>
            <td><a href="deleteProduct?product.id=${p.id}">delete</a></td>
        </tr>
    </s:iterator>
</table>

<br/>

<form action="addProduct" method="post">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>
                categorys:
            </td>
            <td>
                <select name="product.category.id">
                    <s:iterator value="categoryList" var="cl">
                        <option value="${cl.id}">${cl.name}</option>
                    </s:iterator>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                name:
            </td>
            <td>
                <input type="text" name="product.name" value="">
            </td>
        </tr>
        <tr>
            <td>
                price:
            </td>
            <td>
                <input type="text" name="product.price" value="0">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>

</form>
<s:debug/>
</body>
</html>
