## 04-Hibernate & Mybatis
#### 0、Hibernate & Mybatis 概述
**什么是Hibernate：**
> Hibernate是一个开放源代码的**对象关系映射框架**，它对JDBC进行了非常轻量级的对象封装，它将POJO与数据库表建立映射关系，是一个全自动的orm框架，hibernate可以自动生成SQL语句，自动执行，使得Java程序员可以随心所欲的使用对象编程思维来操纵数据库。 

**什么是Mybatis：**
> MyBatis 是一款优秀的**持久层框架**，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs映射成数据库中的记录

#### 1、Hibernate 基础 
- 配置文件

```
## hibernate.cfg.xml 放在类目录下
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>
        <!-- Database connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://ipaddr:3306/04-HibernateAndMybatis?characterEncoding=UTF-8</property>
        <property name="connection.username">root</property>
        <property name="connection.password">password</property>
        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="current_session_context_class">thread</property>
        <property name="show_sql">true</property>
        <property name="hbm2ddl.auto">update</property>
        <mapping resource="com/Tooi/pojo/Product.hbm.xml" />
        <mapping resource="com/Tooi/pojo/category.hbm.xml" />
    </session-factory>

</hibernate-configuration>
```

```
## Product.cfg.xml  映射文件
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE hibernate-mapping PUBLIC
        "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping package="com.Tooi.pojo">
    <class name="Product" table="product_">
        <id name="id" column="id">
            <generator class="native"></generator>
        </id>
        <property name="name"/>
        <property name="price"/>
    </class>

</hibernate-mapping>
```
- 对象状态
- 插入
- 获取
- 删除
- 修改
- 查询-hql
- 查询-Criteria
- 查询-标准sql