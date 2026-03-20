# Plugins

[English](./README.md) | [简体中文](./README_cn.md)

The following plugins are defined in the  [`build.gradle`](./build.gradle)  file.

## `hope.optional`

### Overview

This plugin introduces support for Maven-style **optional dependencies** by creating a new configuration
named `optional`. Dependencies added to this configuration are included in the project’s **compile** and **runtime
classpaths**, but they do **not propagate** to dependent projects.

This behavior is particularly useful when you want to include certain dependencies for internal use without forcing
downstream consumers to include them unnecessarily.

### Usage

When using the shared template file [`spring.lib.gradle`](../gradle/spring.lib.gradle), apply the plugin as follows:

```groovy
apply plugin: "hope.optional"
//or use it standalone:
//id "hope.optional"

optional(libs.spring.context)
```

### Origin

This concept was inspired by Spring Framework’s implementation:
[OptionalDependenciesPlugin](https://github.com/spring-projects/spring-framework/blob/main/buildSrc/src/main/java/org/springframework/build/optional/OptionalDependenciesPlugin.java)
