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

***

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
```
## 指定bean的init和destory方法
<bean id="helloWorld"  class="com.tutorialspoint.HelloWorld" 
    init-method="init" destroy-method="destroy">
   <property name="message" value="Hello World!"/>
</bean>

## 默认的init和destory方法
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd"
    default-init-method="init" 
    default-destroy-method="destroy">
    ...
</beans>
```
- **Bean 后置处理器**
> Bean 后置处理器允许在调用初始化方法前后对 Bean 进行额外的处理。通过继承org.springframework.beans.factory.config.BeanPostProcessor类来实现  
**ApplicationContext 会自动检测由 BeanPostProcessor 接口的实现定义的 bean，注册这些 bean 为后置处理器，然后通过在容器中创建 bean，在适当的时候调用它。**

```
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;
public class InitHelloWorld implements BeanPostProcessor {
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("BeforeInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("AfterInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }
}
```
- **Bean 定义继承**
> 你可以定义一个父 bean 的定义作为模板和其他子 bean 就可以从父 bean 中继承所需的配置。

```
<bean id="helloWorld" class="com.tutorialspoint.HelloWorld">
  <property name="message1" value="Hello World!"/>
  <property name="message2" value="Hello Second World!"/>
</bean>

<bean id="helloIndia" class="com.tutorialspoint.HelloIndia" parent="helloWorld">
  <property name="message1" value="Hello India!"/>
  <property name="message3" value="Namaste India!"/>
</bean>
```
- **Bean 定义模板**
> 你可以创建一个 Bean 定义模板，不需要花太多功夫它就可以被其他子 bean 定义使用。在定义一个 Bean 定义模板时，你不应该指定类的属性，而应该指定带 true 值的抽象属性

```
<bean id="beanTeamplate" abstract="true">
  <property name="message1" value="Hello World!"/>
  <property name="message2" value="Hello Second World!"/>
  <property name="message3" value="Namaste India!"/>
</bean>

<bean id="helloIndia" class="com.tutorialspoint.HelloIndia" parent="beanTeamplate">
  <property name="message1" value="Hello India!"/>
  <property name="message3" value="Namaste India!"/>
</bean>
```
> 父 bean 自身不能被实例化，因为它是不完整的，而且它也被明确地标记为抽象的。当一个定义是抽象的，它仅仅作为一个纯粹的模板 bean 定义来使用的，充当子定义的父定义使用。

***

### 3、Spring 依赖注入
> Spring框架的核心功能之一就是通过依赖注入的方式来管理Bean之间的依赖关系。

> 依赖注入主要有两种变形：**基于构造函数**、**基于setter方法**
#### 基于构造函数

```
<!-- Definition for textEditor bean -->
<bean id="textEditor" class="com.tutorialspoint.TextEditor">
  <constructor-arg ref="spellChecker"/>
  <constructor-arg type="java.lang.String" value="Zara"/>
  <constructor-arg index="2" value="2019"/>
</bean>

<!-- Definition for spellChecker bean -->
<bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
</bean>
```
#### 基于setter方法

```
<!-- Definition for textEditor bean -->
<bean id="textEditor" class="com.tutorialspoint.TextEditor">
  <property name="spellChecker" ref="spellChecker"/>
</bean>

<!-- Definition for spellChecker bean -->
<bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
</bean>

## 也可使用p-namespace的方式
<bean id="john-classic" class="com.example.Person"
  p:name="John Doe"
  p:spouse-ref="jane"/>
</bean>

<bean name="jane" class="com.example.Person"
  p:name="John Doe"/>
</bean>
```
#### 注入内部Bean

```
<!-- Definition for textEditor bean using inner bean -->
<bean id="textEditor" class="com.tutorialspoint.TextEditor">
  <property name="spellChecker">
     <bean id="spellChecker" class="com.tutorialspoint.SpellChecker"/>
   </property>
</bean>
```
#### 注入集合

```
<!-- Bean Definition to handle references and values -->
<bean id="..." class="...">

  <!-- Passing bean reference  for java.util.List -->
  <property name="addressList">
     <list>
        <ref bean="address1"/>
        <ref bean="address2"/>
        <value>Pakistan</value>
     </list>
  </property>

  <!-- Passing bean reference  for java.util.Set -->
  <property name="addressSet">
     <set>
        <ref bean="address1"/>
        <ref bean="address2"/>
        <value>Pakistan</value>
     </set>
  </property>

  <!-- Passing bean reference  for java.util.Map -->
  <property name="addressMap">
     <map>
        <entry key="one" value="INDIA"/>
        <entry key ="two" value-ref="address1"/>
        <entry key ="three" value-ref="address2"/>
     </map>
  </property>

</bean>
```

***

### 4、Spring Beans自动装配
> 可以使用<bean>元素的 autowire 属性为一个 bean 定义指定自动装配模式
- byName
- byType
- constructor
- autodetect

***

### 5、Spring 基于注解的配置
> 注解连线在默认情况下在 Spring 容器中不打开。因此，在可以使用基于注解的连线之前，我们将需要在我们的 Spring 配置文件中启用它  

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">

    <!-- 启用Spring注解 -->
   <context:annotation-config/>
   
</beans>
```
- **@Required**
> 它表明受影响的 bean 属性在配置时必须放在 XML 配置文件中
- **@Autowired**
> 自动连接 bean,可以用在setter方法、属性、构造方法中
- **@Qualifier**
> 指定装配时使用哪一个bean
- **@Configuration**  
> 带有 @Configuration 的注解类表示这个类可以使用 Spring IoC 容器作为 bean 定义的来源

```
@Configuration
public class HelloWorldConfig {
   @Bean 
   public HelloWorld helloWorld(){
      return new HelloWorld();
   }
}
```
- **@import**
> 允许从另一个配置类中加载 @Bean 定义

#### Spring 中的事件处理  
![image](https://note.youdao.com/yws/api/personal/file/042325A5BF2A4AF89F44A076DCBC9A9B?method=download&shareKey=5f0c3a35b7252d290af44ef2e142d152)
