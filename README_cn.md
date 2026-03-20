# 快速入门

[English](./README.md) | [简体中文](./README_cn.md)

**SDK** 📦

最新版本: <a target="_blank" href="https://search.maven.org/artifact/com.apihug/it-bom"><img src="https://img.shields.io/maven-central/v/com.apihug/it-bom.svg" alt="Maven Central"/></a>

**插件** 💻

在 IntelliJ IDEA 中安装 **ApiHug - API 设计 Copilot** 插件:
[ApiHug - API 设计 Copilot](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)

## 快速开始指南 (5 分钟) ⏱️

### 额外参数 🔧

| 参数                 | 描述                                                       |
|--------------------|----------------------------------------------------------|
| `-x test`          | 跳过测试以加快构建速度。                                             |

⚠️ Windows 系统，可能需要使用 `gradlew.bat` 而不是 `gradlew`。

### 步骤说明 🚀

#### 0. 整体编译

```shell
./gradlew clean build -x test
```

#### 1. 构建 Wire 模块（可选）

```shell
./gradlew :rad-app:clean :rad-app:wire -x test
```

#### 2. 运行应用程序

```shell
./gradlew :rad-app:bootRun
```

启动应用程序后，您将看到以下日志输出：

```shell
Application 'rad-app' is running! Access URLs:

Local                    http://localhost:18089/
External                 http://192.168.0.1:18089/
OAS                      http://192.168.0.1:18089/v3/api-docs
Actuator                 http://192.168.0.1:18089/management
Api-Errors               http://192.168.1.105:18089/hope/meta/errors                     
Api-Dictionaries         http://192.168.1.105:18089/hope/meta/dictionaries               
Api-Authorities          http://192.168.1.105:18089/hope/meta/authorities                
Api-Versions             http://192.168.1.105:18089/hope/meta/versions    
Active Profile(s):       dev
```

🥳 恭喜！您已成功启动应用程序。

🧠 [提示](TIPS.md)

## 参考文档 📘

如需更多信息，请参考以下资源：

1. [Apihug GitHub 仓库](https://github.com/apihug/apihug.com/)
2. [Apihug Wire 插件文档](https://github.com/apihug/apihug.com/blob/master/docs/handbook/004_dsl_implement_wire.md)
3. [Apihug Stub 插件文档](https://github.com/apihug/apihug.com/blob/master/docs/handbook/005_dsl_implement_stub.md)
4. [Apihug 相关信息](https://github.com/apihug/apihug.com/blob/master/docs/handbook/099_trivial.md)
5. [Apihug 常见问题解答](https://github.com/apihug/apihug.com/blob/master/docs/handbook/999_faq.md)
6. [官方 Gradle 文档](https://docs.gradle.org)
7. [Spring Boot Gradle 插件参考指南](https://docs.spring.io/spring-boot/docs/3.2.0/gradle-plugin/reference/html/)
8. [ApiHug - API 设计 Copilot IDEA 插件](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)
9. [ApiHug - IDEA 常见问题解答](https://github.com/apihug/apihug.com/blob/master/docs/IDE/999_FAQ.md)
10. [ApiHug - IDEA 手册](https://github.com/apihug/apihug.com/blob/master/docs/IDE/README.md)
11. [ApiHug101 在 Bilibili](https://www.bilibili.com/video/BV1KK421k7J8/)
12. [ApiHug101 在 YouTube](https://youtube.com/@ApiHug?si=C1yw0poHA01zbmyj)
13. [ApiHug 官方网站](https://apihug.github.io) | [ApiHug 商业站点](https://www.apihug.com)
14. [0.7.8-RELEASE 发布说明](https://github.com/apihug/apihug.com/blob/master/docs/framework/versions/0.7.8.md)