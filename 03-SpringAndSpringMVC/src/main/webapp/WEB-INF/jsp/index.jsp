<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/15
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Page Redirection</title>
</head>

<body>
<h2>Click below button to redirect the result to new page</h2>
<form:form method="get" action="/note_Java/03_SpringAndSpringMVC/redirect">
    <tr>
        <td>
            <input type="submit" value="Redirect Page"/>
        </td>
    </tr>
</form:form>
<p>Click below button to get a simple HTML page</p>
<form:form method="get" action="/note_Java/03_SpringAndSpringMVC/staticPage">
    <table>
        <tr>
            <td>
                <input type="submit" value="Get HTML Page"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
