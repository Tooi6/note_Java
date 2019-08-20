<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/19
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>edit.jsp</title>
</head>
<body>

<form action="updateProduct" method="post">
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
                <input type="text" name="product.name" value="${product.name}">
            </td>
        </tr>
        <tr>
            <td>
                price:
            </td>
            <td>
                <input type="text" name="product.price" value="${product.price}">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="product.id" value="${product.id}">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
