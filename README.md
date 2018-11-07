**项目说明** 
- 采用SpringBoot、MyBatis框架。
- 提供了代码生成器，可快速完成开发任务
- 支持MySQL数据库
- 引入swagger文档支持，方便编写API接口文档
<br>

**项目结构** 
```
demo-parent
├─demo-common     公共模块
│    ├─exception       自定义异常
│    └─util            工具类
│ 
├─demo-module      业务模块
│    ├─config  spring boot 配置
│    ├─execpiton  controller层异常处理 
│    ├─module  模块
│    │    └─mobile 移动端
│    │         ├─controller  控制器
│    │         ├─mapper      持久层
│    │         ├─model       模型
│    │         │   ├─dto         数据传输对象
│    │         │   └─entity      数据对象
│    │         └─service     服务层
│    │
│    ├─ DemoApplication  程序入口
│    │
│    └─resources 
│        ├─generator              MyBatis代码自动生成配置
│        ├─mapper                 MyBatis文件
│        ├─application.yml        全局配置文件
│        ├─application-dev.yml    开发模式配置文件
│        ├─application-pro.yml    正式模式配置文件
│        ├─application-test.yml   测试模式配置文件
│        └─logback-spring.xml     日志配置文件
```

<br>

**controller命名规范**
```java
@RequestMapping("/api/mobile/contact")
public class ContactController {
    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public R list(@RequestParam Map<String, Object> params){
    }

    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public R info(@PathVariable("id") Long id){
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody SysDictEntity dict){
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public R update(@RequestBody SysDictEntity dict){
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public R delete(@RequestBody Long[] ids){
    }
}
```

**技术选型：** 
- 核心框架：Spring Boot 2.0
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatisPlus 2.1.9、 MyBatis 3.4
- 数据库连接池：Druid 1.10
- 文档描述: Swagger 2.7
- 日志管理：SLF4J 1.7、Logback
- 工具类: Guava 23.6、Lombok 1.18

<br>

**软件需求** 
- JDK1.8
- MySQL5.5+
- Maven3.0+

<br>

**本地部署**
- 通过gitlib下载源码
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
