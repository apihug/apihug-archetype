# 插件说明

[English](./README.md) | [简体中文](./README_cn.md)

以下插件定义在 [`build.gradle`](./build.gradle) 文件中。

## `hope.optional`

### 概述

该插件为项目引入了对 **Maven 风格可选依赖（Optional Dependencies）** 的支持。它会创建一个新的配置项 `optional`
。添加到该配置中的依赖会被包含在当前项目的 **编译时** 和 **运行时类路径（classpath）** 中，但不会传递给依赖该项目的其他模块或工程。

这种机制在希望引入某些内部使用依赖、而不希望这些依赖强制影响下游项目时非常有用。

### 使用方式

当使用共享模板文件 [`spring.lib.gradle`](../gradle/spring.lib.gradle) 时，请按如下方式应用该插件：

```groovy
apply plugin: "hope.optional"
//或者独立使用:
//id "hope.optional"

optional(libs.spring.context)
```

### 起源

该插件的设计灵感来源于 Spring Framework 的实现：
[OptionalDependenciesPlugin](https://github.com/spring-projects/spring-framework/blob/main/buildSrc/src/main/java/org/springframework/build/optional/OptionalDependenciesPlugin.java)
