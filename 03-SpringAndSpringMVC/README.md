## 03-Spring & SpringMVC
#### 0、Spring概述
> Spring是一个**轻量级**的控制反转(IoC)和面向切面(AOP)的**容器框架**。  
它由Rod Johnson创建。它是为了解决企业应用开发的复杂性而创建的。Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。

[Spring 官网](https://spring.io/) 
- ##### 依赖注入（DI）
> 控制反转（IoC）是一个**通用的概念**，它**可以用许多不同的方式去表达**，依赖注入仅仅是控制反转的一个具体的例子。  

**什么是依赖注入？**
> 当某个角色需要另外一个角色协助的时候，在传统的程序设计过程中，通常由调用者来创建被调用者的实例。但在spring中创建被调用者的工作不再由调用者来完成，因此称为控制反转。创建被调用者的工作由spring来完成，然后注入调用者 
因此也称为依赖注入。
- ##### 面向切面的程序设计（AOP）
> 面向切面编程（AOP）完善spring的依赖注入（DI），在 OOP 中模块化的关键单元是**类**，而在 AOP 中模块化的关键单元是**方面**。AOP 帮助你将**横切关注点从它们所影响的对象中分离出来**，然而**依赖注入帮助你将你的应用程序对象从彼此中分离出来**

#### 1、Spring体系结构 
![image](https://note.youdao.com/yws/api/personal/file/02239BE863C348388929B3CA3E18C5C8?method=download&shareKey=b2d1d0a2086dd692cef86c648e094f64)
- **spring-core：** 框架的基本组成部分，包括IOC和依赖注入的功能
- **spring-beans：** 提供 BeanFactory
- **context：** 建立在由core和 beans 模块的基础上建立起来的，它以一种类似于JNDI注册的方式访问对象
- **spring-expression：** 提供了强大的表达式语言，用于在运行时查询和操作对象图
****
### 2、Spring IOC容器
> **IOC 容器：** 具有 **依赖注入** 功能的容器，它可以创建对象，IOC 容器负责 **实例化、定位、配置** 应用程序中的对象及建立这些对象间的依赖。通常new一个实例，控制权由程序员控制，而"控制反转"是指new实例工作不由程序员来做而是交给Spring容器来做

#### Spring的两种不同的容器：  
- **1、Spring BeanFactory 容器：**
> 这是一个最简单的容器，它主要的功能是为依赖注入 （DI） 提供支持，这个容器接口在 org.springframework.beans.factory.BeanFactor 中被定义。

**XmlBeanFactory：** 这个容器从一个 XML文件中读取配置元数据，由这些元数据来生成一个被配置化的系统或者应用。

- **2、ApplicationContext 容器：**
> 该**容器添加了更多的企业特定的功能**，例如从一个属性文件中解析文本信息的能力，发布应用程序事件给感兴趣的事件监听器的能力。该容器是由org.springframework.context.ApplicationContext 接口定义。  

> ApplicationContext 容器**包括 BeanFactory 容器的所有功能**，所以通常建议超过 BeanFactory。BeanFactory 仍然可以用于轻量级的应用程序，如移动设备或基于 applet 的应用程序，其中它的数据量和速度是显著。

**FileSystemXmlApplicationContext：** 该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径。

**ClassPathXmlApplicationContext：** 该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。

**WebXmlApplicationContext：** 该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。

#### Spring Bean
- **0、Spring Bean的定义**
> Spring IoC 容器完全由实际编写的配置元数据的格式解耦。有下面三个重要的方法把配置元数据提供给 Spring 容器：**基于 XML 的配置文件、基于注解的配置、基于 Java 的配置**

**Bean的属性：**  
![image](https://note.youdao.com/yws/api/personal/file/0D91B08C109146489CC12777BC4A897B?method=download&shareKey=94093f6f0c2c71efa91bfacc1fdc6d6d)  
**Bean与Spring容器的关系：**  
![image](https://note.youdao.com/yws/api/personal/file/6EA48F60BBD743B7B07F82E13AD87F18?method=download&shareKey=cf2233c241288d402f53289430b45665)
- **1、Bean的作用域：**  
![image](https://note.youdao.com/yws/api/personal/file/9B97E90BD44B4B6594847A71543AC53B?method=download&shareKey=9c37e27c9d426fd8f10063a88071ba9e)
- **2、Bean的生命周期：**  
> Bean的生命周期可以表达为：Bean的定义——Bean的初始化——Bean的使用——Bean的销毁 
- 