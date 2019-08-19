## 04-Hibernate & Mybatis
#### 0、概念  
> Struts2框架是一个用于开发**Java EE**网络应用程序的开放源代码网页应用程序架构。它利用并延伸了**Java Servlet API**，鼓励开发者采用MVC架构。Struts2以WebWork优秀的设计思想为核心，吸收了Struts框架的部分优点，提供了一个更加整洁的MVC设计模式实现的Web应用程序框架。

https://struts.apache.org/

#### 1、Struts2 基础
- **配置**  

```
## web.xml 配置Struts2过滤器  
<filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
    <dispatcher>FORWARD</dispatcher>
    <dispatcher>REQUEST</dispatcher>
</filter-mapping>

## src目录下配置struts.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <constant name="struts.i18n.encoding" value="UTF-8"></constant>
    <!-- 修改上传文件最大大小 -->
    <constant name="struts.multipart.maxSize" value="10240000"></constant>
    <package name="basicstruts" extends="struts-default">
        <action name="index">
            <result>index.jsp</result>
        </action>
        <action name="showProduct" class="com.Tooi.action.ProductAction" method="show">
            <result name="show">show.jsp</result>
        </action>
        <action name="addProduct" class="com.Tooi.action.ProductAction" method="add">
            <result name="show">show.jsp</result>
        </action>
        <action name="upload" class="com.Tooi.action.UploadAction" method="upload">
            <result>success.jsp</result>
        </action>
    </package>
</struts>

```
