# Getting Started

[English](./README.md) | [简体中文](./README_cn.md)

**SDK** 📦

Latest version: <a target="_blank" href="https://search.maven.org/artifact/com.apihug/it-bom"><img src="https://img.shields.io/maven-central/v/com.apihug/it-bom.svg" alt="Maven Central"/></a>

**Plugin** 💻

Install the **ApiHug - API Design Copilot** plugin for IntelliJ IDEA:
[ApiHug - API design Copilot](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)

## Quick Start Guide (5 Minutes) ⏱️

### Extra Parameters 🔧

| Parameter          | Description                                                                                       |
|--------------------|---------------------------------------------------------------------------------------------------|
| `-x test`          | Skips tests for a faster build.                                                                   |

⚠️ Windows may use `gradlew.bat` instead of `gradlew`.

### Step-by-Step Instructions 🚀

#### 0. Perform a Rough Build

```shell
./gradlew clean build -x test
```

#### 1. Build Wire Module (Optional)

```shell
./gradlew :rad-app:clean :rad-app:wire -x test
```

#### 2. Run the Application

```shell
./gradlew :rad-app:bootRun
```

After starting the application, you will see the following log output:

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

🥳 Congratulations! You have successfully started your application.

🧠 [Tips](TIPS.md)

## Reference Documentation 📘

For additional information, please refer to the following resources:

1. [Apihug GitHub Repository](https://github.com/apihug/apihug.com/)
2. [Apihug Wire Plugin Documentation](https://github.com/apihug/apihug.com/blob/master/docs/handbook/004_dsl_implement_wire.md)
3. [Apihug Stub Plugin Documentation](https://github.com/apihug/apihug.com/blob/master/docs/handbook/005_dsl_implement_stub.md)
4. [Apihug Trivial Information](https://github.com/apihug/apihug.com/blob/master/docs/handbook/099_trivial.md)
5. [Apihug Frequently Asked Questions](https://github.com/apihug/apihug.com/blob/master/docs/handbook/999_faq.md)
6. [Official Gradle Documentation](https://docs.gradle.org)
7. [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/gradle-plugin/reference/html/)
8. [ApiHug - API Design Copilot IDEA Plugin](https://plugins.jetbrains.com/plugin/23534-apihug--api-design-copilot)
9. [ApiHug - IDEA FAQ](https://github.com/apihug/apihug.com/blob/master/docs/IDE/999_FAQ.md)
10. [ApiHug - IDEA Handbook](https://github.com/apihug/apihug.com/blob/master/docs/IDE/README.md)
11. [ApiHug101 on Bilibili](https://www.bilibili.com/video/BV1KK421k7J8/)
12. [ApiHug101 on YouTube](https://youtube.com/@ApiHug?si=C1yw0poHA01zbmyj)
13. [ApiHug Official Website](https://apihug.github.io) | [ApiHug Commercial Site](https://www.apihug.com)
14. [Release Notes for 0.7.8-RELEASE](https://github.com/apihug/apihug.com/blob/master/docs/framework/versions/0.7.8.md)