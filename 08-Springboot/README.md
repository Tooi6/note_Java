## 08-SpringBoot  
#### 0、简介  

#### 1、基础  
- **创建项目**  
- **部署war**  

```
// 修改pom文件，和Application类
@SpringBootApplication
@ServletComponentScan
public class Application extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- **热部署**

```
<!-- 配置依赖和插件 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional> <!-- 这个需要为 true 热部署才有效 -->
</dependency>
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

- **错误处理界面**  

```
// 定义一个Advice 处理异常
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errorPage");
        return mav;
    }
 
}
```
- **配置端口和上下文路径**  

```
# application.properties 文件
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
server.port=8080
server.servlet.context-path=/note_Java
```
#### 2、持久层支持  
- **配置数据库，和添加依赖**

```
## application.xml文件
# 数据库配置
spring.datasource.url=jdbc:mysql://123.207.58.206:3306/note_Java?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=aD#m2fG^
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.hbm2dd1.auto=update
```

```
## pom.xml
<!-- mysql -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

<!-- jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- mybatis -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.1.1</version>
</dependency>

<!-- mybatis分页查询使用的插件 -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>4.1.6</version>
</dependency>
```


- **JPA**
> PA是**Java Persistence API**的简称，中文名Java持久层API，是JDK 5.0注解或XML**描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中**     
真正干活的可能是**Hibernate,TopLink**等等实现了JPA规范的不同厂商,默认是Hibernate。  

```
## 1、创建实体类  
# 使用注解：@Entity，@Table ...
## 2、创建Dao接口，
# extends JpaRepository<Category,Integer>
```
- **Mybatis**

```
## 1、创建实体  
## 2、创建Mapper接口 / 使用xml文件
# 使用注解@Mapper，@Select("[sql]")
# 使用xml文件需要再application.properties文件中指定路径
```
