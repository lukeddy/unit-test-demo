
# unit-test-demo 工程相关

## maven 
1.目录结构：
maven倡导约定优于配置，而maven的约定目录结构为： src/main/java 源码目录  src/test/java 测试目录
maven-surefire-plugin的test目标会自动执行测试源码路径（默认为src/test/java/）下所有符合一组命名模式的测试类:
+ **/Test*.java：任何子目录下所有命名以Test开头的Java类
+ **/*Test.java：任何子目录下所有命名以Test结尾的Java类
+ **/*Tests.java ：任何子目录下所有命名以Tests结尾的Java类
+ **/*TestCase.java：任何子目录下所有命名以TestCase结尾的Java类

2.使用
使用该插件很简单,使用mvn surefire:test或者mvn test都可以运行工程下的单元测试。

3.输出
它会产生两种不同形式的测试结果报告：
1）.纯文本
2）.xml文件格式的
默认情况下，这些文件生成在工程的${basedir}/target/surefire-reports，目录下（basedir指的是pom文件所在的目录）

## 测试覆盖率
Jacoco是一个开源的Java代码覆盖率工具，Jacoco可以嵌入到Ant 、Maven中，并提供了EclEmma Eclipse插件,也可以使用JavaAgent技术监控Java程序。
很多第三方的工具提供了对Jacoco的集成，如Jenkins、 gitlab、sonar等。

+ 1. 添加jacoco-maven-plugin
+ 2. 运行mvn test
maven倡导约定优于配置（sonar、gitlab-ci会自动搜索该目录），输出目录${basedir}/target/site/jacoco
+ 3.查看jacoco报告
打开浏览器，在URL栏输入<工程地址>/target/site/jacoco/index.html


## CI/CD gitlab-ci 
添加.gitlab-ci.yml 那么每一次合并请求（MR）或者push都会触发CI [pipeline](https://docs.gitlab.com/ce/ci/pipelines.html)

[gitlab-ci.yml](.gitlab-ci.yml)
+ mvn 各个阶段 package /verify/deploy
+ sonar:sonar https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Maven
+ org.jacoco:jacoco-maven-plugin:prepare-agent 分析测试覆盖
+ tags：pipeline 指定runner

# 单元测试框架
## [Junit](https://en.wikipedia.org/wiki/JUnit)

[github](https://github.com/junit-team/junit4/wiki)
+ [Assert](https://github.com/junit-team/junit4/wiki/Assertions)
如果测试用例子不好设计，可以file或者json 模拟，[see demo](./src/test/java/com/example/ut/demo/service/RpcServiceTest.java)

+ [Exception](https://github.com/junit-team/junit4/wiki/Exception-testing)
+ [Parameters](https://github.com/junit-team/junit4/wiki/Parameterized-tests)
[see demo](./test/java/com/example/ut/demo/mvc/TaskControllerTests.java)

## 
## [Mockito](https://github.com/mockito/mockito/wiki)
when given then
[see demo](./src/test/java/com/example/ut/demo/service/WorkerSerivceWithMockitoTests.java)
## [Springboot Test](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-test)
[see demo](./src/test/java/com/example/ut/demo/service/WorkerSerivceWithSpringBootTest.java)

# 单元测试注意事项


**Don't Test the Generated Code**
*Lombok @Data sonar 提示代码没有覆盖*

**Don't Test Framework**
*Spring @Bean sonar 提示需要测试覆盖*

**Show some love with your tests** 
*——[Mockito](http://site.mockito.org/)*

