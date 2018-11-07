**项目介绍**
- 采用SpringBoot2.0、MyBatis Plus、 Druid框架；提供代码生成、多数据源及安装部署脚本，让功能开发变得简单。

**项目说明** 
- 完整的项目代码结构
- 提供了项目打包及部署方法
- 提供了代码生成器，可快速完成开发任务
- 支持数据库多数据源
- 支持MySQL数据库
- 引入swagger文档支持，方便编写API接口文档
<br>

**项目结构** 
```
demo-parent
├── README.md     项目说明文档
├── demo-common   项目公共模块
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── github
│                       └── demo
│                           └── common
│                               ├── excepiton  项目自定义异常
│                               └── util       项目工具类
├── demo-generator    代码生成器模块
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── github
│           │           └── demo
│           │               └── gennerator
│           │                   └── CodeGenerator.java  代码生成器主类
│           └── resources
│               └── templates    代码生成模板
└── demo-module   项目模块代码
    ├── src
    │   └── main
    │       ├── assembly    打包配置及程序启动脚本
    │       │   ├── bin           程序启动脚本
    │       │   └── release.xml   打包配置信息
    │       ├── java
    │       │   └── com
    │       │       └── github
    │       │           └── demo
    │       │               ├── DemoApplication.java    程序启动入口
    │       │               ├── config      spring boot 配置
    │       │               ├── db          数据库相关配置
    │       │               │   ├── fill    字段自动填充
    │       │               │   └── multiple  多数据源切换
    │       │               ├── exception
    │       │               │   └── DemoExceptionHandler.java  异常拦截处理
    │       │               └── module  模块代码
    │       │                   ├── db1     db1模块代码 
    │       │                   │   ├── controller    controller层
    │       │                   │   ├── mapper        dao层
    │       │                   │   ├── model         模型
    │       │                   │   └── service       service层
    │       │                   ├── db2     db1模块代码 
    │       │                   │   ├── controller    controller层
    │       │                   │   ├── mapper        dao层
    │       │                   │   ├── model         模型
    │       │                   │   └── service       service层
    │       │                   └── sample    检查是否启动
    │       │                       └── controller
    │       │                           └── SampleController.java
    │       └── resources
    │           ├── application-dev.yml   开发环境配置文件
    │           ├── application-pro.yml   生产环境配置文件
    │           ├── application-test.yml  测试配置文件
    │           ├── application.yml       主配置文件
    │           ├── db                    数据库脚本文件
    │           ├── logback-spring.xml    日志配置
    │           └── mapper                mybatis mapper文件
    └── target
        └── demo-module-0.0.1-SNAPSHOT.tar.gz 编译后生成的安装包
```

<br>

**技术选型：** 
- 核心框架：Spring Boot 2.0
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatisPlus 3.0.5、 MyBatis 3.4
- 数据库连接池：Druid 1.10
- 文档描述: Swagger 2.7
- 日志管理：SLF4J 1.7、Logback
- 工具类: Guava 23.6、Lombok 1.18、Fastjson
- 数据库脚本管理: Flyway
- 代码生成器: Velocity
- 网络请求: Okhttp3
- 二维码生成: Zxing
- 包管理: Maven
- 项目打包: maven-assembly-plugin、maven-jar-plugin
- 单元测试: spring-boot-starter-test、testng
- 数据库: MySQL

<br>

**软件需求** 
- JDK1.8
- MySQL5.5+
- Maven3.0+

<br>

**本地部署**
- 通过github下载源码
- 修改application-dev.yml文件，更新MySQL账号和密码
- 在demo目录下，执行mvn clean package -Dspring.profiles.active=dev， 可以通过spring.profiles.active设置安装的运行环境
- 编译后获取安装包, base-demo/demo-module/demo-module-0.0.1-SNAPSHOT.tar.gz
<br>

**部署结构**
```
demo     根目录
├── bin     命令目录
│   ├── dump.sh     jdk常用命令
│   ├── server.sh   服务命令
│   ├── start.bat   启动程序(windows)
│   ├── start.sh    启动程序(linux)
│   └── stop.sh     停止程序(linux)
├── conf    配置文件目录
│   ├── application.yml         总配置文件
│   ├── application-dev.yml     开发环境配置文件
│   ├── application-test.yml    测试环境配置文件
│   ├── application-pro.yml     正式环境配置文件
│   └── logback-spring.xml      日志配置文件
├── lib     依赖jar包
└── logs    日志目录
    ├── demo.log     日志文件
    └── stdout.log      命令行输出文件
``` 

<br>

**运行程序&停止程序**
 - 进入demo/bin目录下
 - ./start.sh
 - .stop.sh
 
<br>

**运行环境更改**
- 修改conf/application.yml 文件
```
spring:
  profiles:
    active: dev     dev 开发环境, test 测试环境, pro 正式环境
```

<br>
