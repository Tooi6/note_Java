<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/19
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit.jsp</title>
</head>
<body>

<form action="updateCategory" method="post">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>
                name:
            </td>
            <td>
                <input type="text" name="category.name" value="${category.name}">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="hidden" name="category.id" value="${category.id}">
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
