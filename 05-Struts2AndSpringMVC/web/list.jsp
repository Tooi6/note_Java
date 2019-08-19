<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>list.jsp</title>
</head>
<body>
<table align="center">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>st.index</td>
        <td>st.count</td>
        <td>st.first</td>
        <td>st.last</td>
        <td>st.odd</td>
        <td>st.even</td>
    </tr>
    <s:iterator value="products" var="p" status="st">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${st.index}</td>
            <td>${st.count}</td>
            <td>${st.first}</td>
            <td>${st.last}</td>
            <td>${st.odd}</td>
            <td>${st.even}</td>
        </tr>
    </s:iterator>
    <!--
        value：哪些被选中
        name：提交到服务端用的名称
        list:用于遍历的集合
        listValue:显示的checkbox的名称
        listKey:checkbox的value
    -->
    <s:checkboxlist list="products" value="selectProducts" name="product.id" listValue="name" listKey="id"/>
    <br/>
    <!--
        value表示：哪项被选中
        name表示：提交到服务端用的名称
        list:用于遍历的集合
        listValue:显示的radio的名称
        listKey:radio的value
    -->
    <s:radio list="products" value="1" name="product.id" listValue="name" listKey="id"/>
    <br/>
    <!--
        name表示：提交到服务端用的名称
        list:用于遍历的集合
        listKey:每个option的value
        listValue:显示的名称
        multiple:true表示可以选中多行
        size="3"表示默认显示3行
        value表示：哪些被选中
    -->
    <s:select list="products" listKey="id" listValue="name" name="product.id" value="selectProducts" label="products" size="3" multiple="true"/>
    <br/>
    <br/>

    <table border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>products</td>
        </tr>
        <s:iterator value="categories" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>
                    <s:iterator value="#c.products" var="p">
                        ${p.name}
                    </s:iterator>
                </td>
            </tr>
        </s:iterator>
    </table>
    ${date}
    <s:debug/>
</table>
</body>
</html>