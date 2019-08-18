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

#### 2、多表查询  
> com.Tooi.pojo.Product
- 一对多
- 多对一
- 多对多
#### 3、各种概念  
- **事务：**  
> Hibernate的任何对数据有改动的操作，都应该被放在事务里面.在事务中的多个操作行为，要么都成功，要么都失败
- **属性延迟加载：**  
> 当使用**load**的方式来获取对象的时候，只有访问了这个对象的属性，hibernate才会到数据库中进行查询。否则不会访问数据库
- **关系延迟加载：**  
> 延迟加载又叫**lazyload(xml里配置lazy='true')**，在one-many many-many的时候都可以使用关系的延迟加载  
- **级联**
> 级联，就是对一个对象进行操作的时候，会把他相关联的对象也一并进行相应的操作  
- **缓存**  
> Hibernate的一级缓存是在Session上，二级缓存是在SessionFactory上。默认是一级缓存  

```
# 开启二级缓存  

## hibernate.cfg.xml 中增加对二级缓存的配置
<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</property>

## 在src目录下，创建一个ehcache.xml用于EHCache的缓存配置  
<ehcache>
    <diskStore path="java.io.tmpdir"/>
    <defaultCache
        maxElementsInMemory="10000"
        eternal="false"
        timeToIdleSeconds="120"
        timeToLiveSeconds="120"
        overflowToDisk="true"
        />
</ehcache>

## 对于要进行二级缓存的实体类，进行配置，增加
<cache usage="read-only" />
```
- **分页查询**  
- **get和load**
> load方式是延迟加载，只有属性被访问的时候才会调用sql语句  
get方式是非延迟加载，无论后面的代码是否会访问到属性，马上执行sql语句    
**当获取的对象不存在时，load抛出异常，get则返回null**
- **两种获取session方式**  
> Hibernate有两种方式获得session,分别是： **openSession**和**getCurrentSession**   

>**openSession：** 每次都会得到一个新的session，只有在增加，删除，修改时需要事务，查询不需要    
**getCurrentSession：** 在同一个线程中每次都是同一个对象，不同线程则不同对象，所有操作都在事务中，并且事务提交后自动关闭session  
- **query 的list()和iterator()区别**  

```
区别:
 
　　1.返回的类型不一样，list返回List，iterate返回iterator.
　　
　　2.查询策略不同。(获取数据的方式不一样,list会直接查询数据库,iterate会先到数据库中获取id,然后真正遍历某个对象引用的时候,先到缓存中找,如果找不到，以id为条件再发一条sql到数据库，这样如果缓存中没有数据，则查询数据库的次数为n+1).
 
　　3.list中返回的list中每个对象都是其本身的对象，iterate中返回的对象是代理对象.
 
　　4.list只能put不能获取,iterate可以进行获取.
```
- **乐观锁**
> 通过增加version字段，修改数据前会读取version信息，检测version是否被修改如果被修改则报错，没有被修改则修改数据并将version+1
```
## 增加<version>字段
<!-- （必须紧挨在id后面）version 字段用于版本信息控制。这就是乐观锁的核心机制 -->
<version name="version" column="ver" type="int"/>
```
- **数据库连接池** 
> 建立数据库连接时比较消耗时间的，所以通常都会采用数据库连接池的技术来建立多条数据库连接，并且在将来持续使用，从而节约掉建立数据库连接的时间 

- **连接池**

```
## 添加c3p0依赖  

## 在hibernate.cfg.xml下配置连接池
<!-- 配置数据库连接池 -->
<property name="hibernate.connection.provider_class">
    org.hibernate.connection.C3P0ConnectionProvider
</property>
<property name="hibernate.c3p0.max_size">20</property>
<property name="hibernate.c3p0.min_size">5</property>
<property name="hibernate.c3p0.timeout">50000</property>
<property name="hibernate.c3p0.max_statements">100</property>
<property name="hibernate.c3p0.idle_test_period">3000</property>
<property name="hibernate.c3p0.acquire_increment">2</property>
<property name="hibernate.c3p0.validate">false</property>
```
#### 4、注解
> hibernate里常用注解包括，类注解，属性注解，关系注解，其他的注解(具体见项目)。  
#### 5、注解 vs XML  

```
XML配置方式： 
优：容易编辑，配置比较集中，方便修改，在大业务量的系统里面，通过xml配置会方便后人理解整个系统的架构，修改之后直接重启应用即可 
缺：比较繁琐，配置形态丑陋, 配置文件过多的时候难以管理 
注解方式： 
优：方便，简洁，配置信息和 Java 代码放在一起，有助于增强程序的内聚性。 
缺：分散到各个class文件中，所以不宜维护, 修改之后你需要重新打包，发布，重启应用。 

个人体会： 小项目，参与人数不多，不复杂的用注解，开发快速。 复杂项目，多人交互，配置量大，维护复杂度高的，用配置文件。
```

