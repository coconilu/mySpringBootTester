# mySpringBootTester
本项目旨在把SpringBoot的特性展示出来，都是开发中经常用到的，可以留作SpringBoot使用备忘录，持续更新中。
> 每一个特性都会有一个测试用例用于展示，可以用IDE的Run As > JUnit Test查看效果

## 使用SpringTest
使用测试驱动开发的模式，每一个测试类都会由@RunWith(SpringRunner.class)、@SpringBootTest注解，需要测试Http请求的需要添加@WebAppConfiguration注解

## WebMVC，Mock
请看src/test/java/dev/wangyaohui/WebMVCTests.java

过程：
1. 依赖spring-boot-starter-test
2. 里面包含测试RestController请求的用例

## Spring-Data-JPA
请看src/test/java/dev/wangyaohui/JPATests.java

过程：
1. 依赖spring-boot-starter-data-jpa
2. 使用内存数据库H2DB，创建Repository接口后，由Spring创建相应的实例

## Spring-Data-Rest
没有特定的tester，只要项目里声明了@Repository，Spring会自动生成Restful风格的Controller

过程：
1. 依赖spring-boot-starter-data-jpa和spring-boot-starter-data-rest
2. 使用内存数据库H2DB，创建Repository接口后，由Spring创建相应的实例，继而由Spring创建相应的RestController
3. 可以使用postman测试，在项目启动后，可以输入localhost:8080/api/persons访问查看效果

## Spring-AOP
请看
1. src/main/java/dev/wangyaohui/aop/CountingAspect.java
2. src/main/java/dev/wangyaohui/aop/CountingTester.java
3. src/test/java/dev/wangyaohui/AOPTests.java

过程：
1. 依赖spring-boot-starter-aop
2. 测试用例是处理每一个类的添加了@Counting注解的方法，计算每个方法的调用时长

## Spring事务
事务管理器，常用的有几种：
1. JDBC：DataSourceTransactionManager
2. JPA：JpaTransactionManager
3. Hibernate：HibernateTransactionManager
4. JDO：JdoTransactionManager
5. 分布式事务：JtaTransactionManager

SpringBoot会依据我们使用的数据库技术自动配置事务管理器，并自动开启注解事务的支持，不需要在配置类里使用@EnableTransactionManagement注解

使用的方法很简单，在你的业务层（Service层）的类或方法上使用@Transactional注解，并配置你的事务行为，如propagation、isolation、timeout、readOnly、rollbackFor、noRollbackFor

