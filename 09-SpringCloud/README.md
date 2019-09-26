## 09-SpringCould
### 0、简介
#### 单体架构  
> 一个归档包（例如war格式或者Jar格式）包含了应用所有功能的应用程序，我们通常称之为单体应用。架构单体应用的方法论，我们称之为单体应用架构，这是一种比较传统的架构风格。  
- **缺点：**
> 复杂性高、技术债务逐渐上升、部署速度慢、扩展能力受限、障碍技术创新。  
#### 微服务架构  
> 简而言之，微服务架构风格的开发方法，是以开发一组小型服务的方式来开发一个独立的应用系统的。其中每个小型服务都运行在自己的进程中，并经常采用HTTP资源API轻量的机制来相互通信。    
- **优势：**  
> 易于开发和维护、单个微服务启动较快、局部修改容易部署、技术栈不受限、按需伸缩  
- **挑战：**  
> 运维要求较高、分布式固有的复杂性（系统容错、网络延迟、分布式事务）、接口调整成本高、重复劳动（各个服务可能需要相同的业务）  
### 分布式-微服务-集群的区别  
- **分布式**  
> 将一个大的系统划分为多个业务模块，业务模块分别部署到**不同的机器上**，各个业务模块之间通过接口进行数据交互。    
![image](https://note.youdao.com/yws/api/personal/file/BB0D4D6F5EE543B29F2C349CE2FEC19F?method=download&shareKey=e9ab3ee468a84b8f131bd11b8a5c1b30)  
- **集群模式**    
> 集群模式是**不同服务器部署同一套服务**对外访问，实现服务的负载均衡。
![image](https://note.youdao.com/yws/api/personal/file/909B9991AB4B4A8A88B2704DAF4C1EEC?method=download&shareKey=348643d23ee1a88472f7e43c38d1a33d)  
- **微服务架构**  
> 微服务与分布式的细微差别是，微服务的应用不一定是分散在多个服务器上，他也可以是**同一个服务器**。  
![image](https://note.youdao.com/yws/api/personal/file/6957E1BE511F4F059718777F59212BC3?method=download&shareKey=568650fcc478cd140a6f4582e5b8f187)  
**分布式和微服的架构很相似，只是部署的方式不一样而已。**

### 1、DEMO
#### 服务注册中心（EurekaServer）  

```
## pom.xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
</dependencies>

## application.yml  
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

spring:
  application:
    name: eureka-server
server:
  port: 8761  
  
## 启动类 (EurekaServerApplication.java)  
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication.class).run(args);
    }
}
```
#### （Ribbon）微服务

```
## pom.xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>

## client（访问服务）  
@Component
public class ProductClientRibbon {
    @Autowired
    RestTemplate restTemplate;

    public List<Product> listProduct(){
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products",List.class);
    }

}

## application.yml
spring:
  application:
    name: product-data-service
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

## 启动类  
@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceApplication {
    // ...
}
```
### （Feign）微服务  
> Feign 是对 Ribbon的封装，使用注解的方式，调用起来更简单。  

```
## pom.xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
</dependencies>

## client （访问服务，使用注解方式）  
@FeignClient(value = "PRODUCT-DATA-SERVICE")
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProduct();
}  

## 启动类  
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ProductViewServiceFeignApplication {
}  

## application.yml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
spring:
  application:
    name: product-view-service-feign
  thymeleaf:
    cache: false
    prefix: classpath:/template/
    suffix: .html
    encoding: UTF-8
    mode: HTML5
    servlet:
      content-type: text/html

```

### 2、链路追踪服务器（zipkin ）  
> 1、启动服务器，java -jar zipkin-server-2.10.1-exec.jar  
[下载地址](http://how2j.cn/frontdownload?bean.id=2073)  
2、改造service（pom）  

```
## pom.xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency> 

## application.yml  
spring:
  zipkin:
    base-url: http://localhost:9411  

## 添加bean  
@Bean
public Sampler defaultSampler() {
	return Sampler.ALWAYS_SAMPLE;
}  
```  
### 3、配置服务器（config-server）  
### 4、消息总线Bus（RabbitMQ）  
### 5、断路器（Hystrix）
- **配置断路器**  
- **断路器监控服务**  
- **断路器聚合监控**  
### 6、网关（Zuul）  
