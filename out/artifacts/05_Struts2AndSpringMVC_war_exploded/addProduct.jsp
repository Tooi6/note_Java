<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Tooi
  Date: 2019/8/18
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addProduct.jsp</title>
</head>

<body>
    <s:head/>
    <s:fielderror />
    <s:form action="addProduct">
        <input name="product.name" label="product name" value="${param.name}"/>
        <s:submit value="Submit"/>
    </s:form>
    <s:debug/>
</body>
</html>
