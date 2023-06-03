

## 1.IOC-example

#### 程序耦合的问题：
指调用者和被调用者的依赖关系。注意：松耦合是弱关系，不是“没关系”。
#### 开发中遵循的原则：
编译时不依赖，运行时才依赖。最简单的举例，假设我写代码需要用到别人写的类AA，但是这时候类AA压根就不存在或者同事还没写完，我怎么保证编译不报错，不用等同事继续往下写？？（这在多人协同开发的时候得以体现，同样的道理，为什么service和dao需要先写接口再写impl实现类？因为有可能不同的人写不同的service，互相需要调用的时候，为了保证并行开发，先约定接口<即定好方法的入参和返回值>，保证不耽误别人的开发。为什么要前后端分离面向接口开发？这都是同样的道理。）
### 解决方式：

1.使用反射创建类对象----换个说法，使用反射获取“将来”的、“运行时”的类对象。
2.使用工厂模式统一负责创建对象的工作，各个类需要bean找工厂拿，这样就解除了类之间的相互依赖-----把它们互相之间的依赖都转移到了BeanFactory。
3.使用配置文件的方式减少冗余代码，增强可扩展性。
4.使用static Map方式缓存所有创建的对象，实现bean的单例模式
5.读取配置文件使用了java.util.ResourceBundle








案例1：

配置文件 bean.properties
```
userService=service.impl.UserServiceImpl
userDao=dao.impl.UserDaoImpl
```
创建一个bean类用于演示

![image-20210903181433105](../../../../AppData/Roaming/Typora/typora-user-images/image-20210903181433105.png)



![image-20210903181052225](https://raw.githubusercontent.com/ylabbh/javaNotes/main/pic/image-20210903181052225.png)


工厂类BeanFactory
```

public class BeanFactory {

    //------------------------加载配置文件的方式1--------------------------
    /*private static Properties properties = new Properties();

    static {
        try {
            //这里指定的是当前工程spring-learning下的相对路径。---绝对不能这样写，因为打包之后，目录结构就会改变，这里就会找不到配置文件
            //InputStream in1 = new FileInputStream("IOC-example/src/bean.properties");

            //先拿到本类的类加载器，读取相对路径
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
        } catch (IOException e) {
            //静态初始化程序中发生意外异常的信号。抛出 ExceptionInInitializerError 表明在计算静态初始值或静态变量的初始值期间发生异常。
            throw new ExceptionInInitializerError("读取配置文件失败" + e);
        }
    }*/

    //------------------------加载配置文件的方式2-----------------
    /*
    1.它只能读取properties文件，别的文件读不了
    2.它只能用于读取，不能写入
    3.它只能读取类路径下的，不在类路径下读取不了
    注意：不要写扩展名，因为它已经自动识别扩展名.properties，再写会被当成包名
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");

    //一旦加载这个类，就读取配置文件bean.properties，创建所有示例bean放到缓存中，这样就能够实现单例。
    private static Map<String,Object> beanCacheMap = new HashMap<>();
    static {
        Enumeration<String> keys = bundle.getKeys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            String classPath = bundle.getString(key);
            try {
                Object o = Class.forName(classPath).newInstance();
                beanCacheMap.put(key,o);
            }  catch (Exception e) {
                throw new ExceptionInInitializerError("beanFactory初始化失败" + e);
            }
        }
    }


    public static Object getBean(String beanName) {
        Object o = beanCacheMap.get(beanName);
        return o;
    }

    public static void main(String[] args) {
        System.out.println(bundle.getString("userService"));
    }

}
```
具体流程：
1.BeanFactory一加载，使用ResourceBundle读取配置文件，得到配置好的类的包路径,通过   Object o = Class.forName(classPath).newInstance();反射创建所有对象，并放到放置到beanCacheMap缓存中。使用时直接指定beanName获取，这时候得到的将会是单例的bean，因为对象只在初始化的时候创建了一次。



````
## 2.helloSpring
最基础的spring演示，使用xml配置文件形式创建bean并使用。
相关知识点：
```ClassPathXmlApplicationContext:它只能加载类路径下的配置文件
  FileSystemXmlApplicationContext:它能加载磁盘任意位置的配置文件
  
  Bean的两种创建规则：
   1.BeanFactory-延迟加载，用到才创建
   2.ApplicationContext-立即加载，一旦解析完配置文件就立马创建。
  
  Bean的三种创建方式：（看springContext.xml）
   1.调用默认无参构造函数，如果没有则创建失败会报异常  
        <bean id=".." class="...."></>
   2.使用静态工厂中的方法创建，需要使用             
        <bean id="userDao2" class="util.StaticBeanFactory" factory-method="getUserDaoBean"/>
   3.使用实例工厂中的方法                        
        <bean factory-bean="...." factory-method="..."</>
  
  Bean的作用范围 <bean scope="..."></>
   singleton:单例（默认值）
   prototype：多例的
   request：作用范围是一次请求，和当前请求的转发
   session：作用范围是一次会话
   globalsession：一次全局会话
  
  Bean的生命周期：
       涉及bean标签的两个属性：
           <bean init-method="..."></>
           <bean destroy-method="..."></>
       单例：
           出生：容器创建，对象就创建
           活着：只要容器存在，对象就一直存在
           死亡：容器销毁，对象死亡
       多例：
           出生：每次使用时创建对象
           活着：只要对象在使用中，就一直存在
           死亡：长时间不适用，也没有别的对象引用时，由java的垃圾回收器回收。

  2.Bean的后置处理器  

        Spring IoC 后置处理器，初始化Bean之后会调用该接口两个方法，我们一般可以利用此接口来统计,检查甚至改变Bean的实例对象

        public interface BeanPostProcessor {
            default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
               //如果返回null,ioc容器还是会用原来的bean，如果不为null ioc就会注册返回的bean对象
                return bean;
            }
            default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
               //如果返回null,ioc容器还是会用原来的bean，如果不为null ioc就会注册返回的bean对象
                return bean;
            }
        }
       
        
```
## 3-springDI
演示spring依赖注入的各种方式

相关知识点
```
   spring的依赖注入：
       三种方式：
           1.使用有参构造函数
           2.使用set方式注入
           3.使用注解方式注入
       注入的数据类型有3类
           1.基本类型和String类型
           2.其它bean类型(必须是在spring的配置文件中出现过的bean)
           3.复杂类型(List,Set....)
 
 
   一、构造函数注入：
       配合 <constructor-arg />标签
       标签的属性：
           type：指定参数的类型
           index：指定参数的索引位置，0开始
           name：指定参数名称（常用）
       ----------------上面三个是指定给哪个参数复制，下面两个属性是指定赋的什么值-------------
       value：指定基本数据类型或String类型的数据
       ref：指定其他bean类型数据
 
   二、set注入：
       声明set方法，配合 <property/> 标签注入
   三、复杂类型注入
       数组[] ：<array><value>...</></>
       列表list： <list><value>...</></>
       set:    <set><value>...</></>
       map:    <map><entry key="..">...</></>
       Properties: <props> <prop key="...">...</></>
```
##4-annotationIOC
使用注解方式
1.配置注解驱动和包扫描
```
<context:annotation-config/>
<context:component-scan base-package="service;dao"></context:component-scan>
```
2.
```
/**
 * spring基于注解开发，根据用途：
 * 1.用于创建bean对象
 *      @conpoment(组件)--相当于配置了一个bean
 *          作用于：类
 *          属性：value。--指定bean的id，若不写，默认为当前类首字母改小写。
 *      由此注解衍生出了三个类似注解：
 *          @Controller     用于表现层
 *          @Service        用于业务层
 *          @Repository     用于持久层
 *      他们和@Component作用及属性都是一模一样的
 *
 * 2.用于注入数据的
 *          @Autowared(required = false)
 *              自动按照类型注入，只要有位移类型匹配就能注入成功。使用注解不需要set方法。
 *              如果同一接口有多个实现类，根据变量名作为id匹配bean的名称，在容器中查找。
 *              如果 required = false,那么如果启动时容器找不到不会报错
 *          @Qualifier("...")
 *              value：在Autowared的基础上，再根据bean的id注入。
 *              只能用于给方法形参注入时使用。
 *          @Resource
 *              直接按照bean的id注入
 *          ----上面三个用于注入其他bean类型----
 *
 *          @Value
 *              用于：基础类型和String类型。它可以借助spring的el表达式读取properties文件中的配置。
 *
 * 3.用于改变作用范围的
 * @Scope
 *      改变bean的作用范围
 *
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService {

    @Value("看门见三")
    private String name;

    //@Autowired
    //@Qualifier("userDao1")
    @Resource
    private UserDao userDao;

    public void sayHello() {
        userDao.sayHello();
        System.out.println(name);
    }

}
```
##4-annotationIOC1
1.完全使用注解方式，不需要xml配置文件，而是使用配置类的方式
```
使用纯注解的方式配置spring容器，使用到的注解有：
 1.@ComponentScan({"包路径1","包路径2"....}) //包扫描
 2.@Import(value = 其它配置类.class)  //加载其它配置类
 3.@PropertySource(value = {"classpath:....配置文件路径"})  //加载其它配置文件
 4.@Qualifier("...")   //用于注入方法形参
 5.@Bean注解，比较复杂，看下面


    /*方法返回值存入spring容器中，该注解有一个属性：name，用于指定bean的id。如果不写默认是方法名
        方法形参这里，没有任何注解，但是同样自动注入，它的规则是：
        1.从容器中找类，如果类唯一，注入。
        2.如果类不唯一，找id，如果id跟参数名dataSource有匹配的，注入
        3.如果id没有匹配的，报错。
        4.这时候也可以使用形参注解 @Qualifier("beanName")*/
        @Bean
        public QueryRunner createQueryRunner(@Qualifier("dataSource2")DataSource dataSource){
            return new QueryRunner(dataSource);
        }


 6.@Value("${...}")  使用了spring的el表达式。刚才我们通过@PropertySource注解读取到的配置文件都可以用@Value注解获取并注入
@ComponentScan({"dao","service"})
//导入配置类，最后这些配置都会被加载，然后创建对象进入容器，跟spring.XML配置形式是一样的效果
@Import(value = DBConfig.class)
//读取配置文件的路径
@PropertySource(value = {"classpath:jdbc.properties"})
public class SpringConfig {

}

```

2.演示如何使用spring的单元测试
```
/*
 演示spring的单元测试
 1.引入依赖
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.1.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>compile</scope>
    </dependency>
  2.@RunWith(SpringJUnit4ClassRunner.class) 固定写法
  3.@ContextConfiguration加载配置文件
  4.方法上打上@Test注解
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:ApplicationContext.xml"}) //加载xml配置文件
@ContextConfiguration(classes = SpringConfig.class) //加载class配置文件
public class SpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws SQLException {
        userService.sayHello();
    }

}

```
##5-dynamic-proxy-demo
演示动态代理，这一块看知乎的一个帖子，介绍的比较详细。
``
https://www.zhihu.com/question/20794107
``
假设现在有3个service，有一个需求是要给所有service方法前后做日志保存的处理。如何实现呢？
1.最蠢的方式，在每个方法前后增加<打日志>的代码。---这显然不可取，日志管理是独立功能，与业务代码的逻辑无关，不应该混在一起。同时这样根本没法维护，不优雅。
2.通过代理模式，对类进行增强。---这样可以在不动原有业务代码的前提下实现新的功能，同时将<打日志>的功能单独抽离出来方便管理。

1.先演示静态代理。
![avator](静态代理-1代理类实现相同接口.png)
![avator](静态代理-2代理类具体实现.png)

对于打日志这种功能，我们无非就是记录一下方法名、参数、时间、异常等信息。不论多少个service都是一样的。但是如果使用静态代理，我们不得不对每一个service都编写一个proxy类。如果有1000个servcie，也同样需要编写1000个proxy类。但是它们做的事实际上是差不多的！！也就是说会出现大量重复代码。这就是静态代理的毛病。

2.演示动态代理
思想和静态代理是一致的，即“代理对象 应该和 实际对象 在“表现”上保持一致。（入参，返回值，方法名等）”
至于具体实现，解释起来比较复杂，理解了也很难记住，暂时先看代码吧。实话讲看了很多帖子依旧不是很理解。

简单来说，动态代理对象是运行时，JDK通过反射动态生成的代理类最终构造的对象，JDK生成的类在加载到内存之后就删除了，所以看不到类文件
注意，这里只演示JDK的动态代理，CGLIB的动态代理甚至不需要要求目标类实现接口，可直接根据类生成代理对象，这里没有演示。



## 7-jdbcTemplete
![avator](数据库框架.png)
1.演示在xml配置中，如何引入.properties配置文件的内容
    一种是使用spring提供的一个标签，在spring-config.xml中配置单个properties，如下
```
<context:property-placeholder location="classpath:test.properties"/>
```
配置多个properties通过分号隔开在后面添加即可，例如
```
<context:property-placeholder location="classpath:test.properties,classpath:jdbc.properties"/>
``` 

另一种是通过注到bean的属性来进行配置，这里也是配置多个,如下
```
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
      <property name="locations">
          <list>
              <value>classpath:jdbc.properties</value>
              <value>classpath:test.properties</value>
          </list>
      </property>
</bean>
```
取值方式如下：
    在spring-config.xml中获取properties文件中的值：
```
<task:scheduled-tasks>
　　<task:scheduled ref="testJob" method="logArchiveBak" cron="${logArchiveCron}" />
</task:scheduled-tasks>
```
在java类里面获取properties文件里面的值，通过注解@value(${key})来获取
```
@Value("${name}")
  private String name;
  @Value("${password}")
  private String password;
```
2.演示基本的jdbcTemplate用法，因为一般都是用mybatis，所以这里不做更多演示。简单体验一下。
首先我们有表如下：
![avator](数据表.png)
建表语句：
```
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_id` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `class` VALUES (2, '一班', 2);
INSERT INTO `class` VALUES (3, '二班', 1);
INSERT INTO `class` VALUES (4, '佛挡杀佛', 2);

```

1.pom.xml引入jdbcTemplate依赖。
```
<!-- Spring-jdbc 用于配置JdbcTemplate -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.0.9.RELEASE</version>
        </dependency>
```

2.声明bean
```
public class ClassTable implements Serializable {
    
    private String id;
    private String name;
    private String student_id;
    
    //get/set方法...
}

```

3.配置数据库连接

dbConfig.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <context:property-placeholder location="classpath:jdbc.properties"/>


    <!-- 配置数据源-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <!-- Mysql数据库驱动-->
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <!-- 连接数据库的url-->
        <property name="url" value="${jdbc.jdbcUrl}"></property>
        <!-- 连接数据库的用户名-->
        <property name="username" value="${jdbc.userName}"></property>
        <!-- 连接数据库的密码-->
        <property name="password" value="${jdbc.password}"></property>
    </bean>

    <!-- 配置Jdbc模板-->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

</beans>
```
jdbc.properties

```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.jdbcUrl=jdbc:mysql://localhost:3306/test?serverTimezone=UTC
jdbc.userName=root
jdbc.password=root
```
4.实际使用
```
@Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("dbConfig.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        List<ClassTable> query = jdbcTemplate.query("select * from class;", new BeanPropertyRowMapper<ClassTable>(ClassTable.class));
        for (ClassTable aClass : query) {
            System.out.println(aClass);
        }
    }
```
四步，简简单单。




JDBCUtil：https://blog.csdn.net/weixin_43908649/article/details/110239301
````

![image-20210903180813813](https://raw.githubusercontent.com/ylabbh/javaNotes/main/pic/image-20210903180813813.png)

