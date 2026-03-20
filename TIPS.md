## Tips


1. **[gradle-wrapper.properties](./gradle/wrapper/gradle-wrapper.properties)**: Adjust the `networkTimeout=9999999` value as needed to prevent timeout issues during the initial Gradle build.
2. **[settings.gradle](./settings.gradle)**: The entry `org.gradle.toolchains.foojay-resolver-convention` is used to maintain the Java toolchain configuration and should be retained accordingly.
3. **[libs.versions.toml](./gradle/libs.versions.toml)**: This file is designated for managing versions of third-party libraries. Hardcoding dependency versions in build scripts is strongly discouraged.
4. **[spring-lib.gradle](./gradle/spring-lib.gradle)**: This Gradle template is intended for developing Spring extension libraries, as opposed to standard Spring Boot applications.
5. **[spring-lib-ai.gradle](./gradle/spring-lib-ai.gradle)**: This Gradle template serves as a foundation for extending Spring AI functionality.


Upon the initial Gradle upgrade (in case the local version is not present), and the subsequent downloading of a multitude of third-party libraries, the process may require several minutes to approximately half an hour for completion. 

We appreciate your patience during this time.

---


1. **[gradle-wrapper.properties](./gradle/wrapper/gradle-wrapper.properties)**：可根据需要调整 `networkTimeout=9999999` 的值，以避免首次构建 Gradle 时出现超时问题。
2. **[settings.gradle](./settings.gradle)**：配置项 `org.gradle.toolchains.foojay-resolver-convention` 用于维护 Java 工具链设置，请保留并根据需要进行调整。
3. **[libs.versions.toml](./gradle/libs.versions.toml)**：该文件用于统一管理第三方库的版本，**请勿在构建脚本中硬编码依赖版本**。
4. **[spring-lib.gradle](./gradle/spring-lib.gradle)**：该 Gradle 模板用于开发 Spring 扩展类库，适用于非 Spring Boot 应用的场景。
5. **[spring-lib-ai.gradle](./gradle/spring-lib-ai.gradle)**：该 Gradle 模板用于扩展 Spring AI 功能，可作为相关开发的基础模板使用。


如是首次升级 Gradle（本地无对应版本），系统将自动下载大量第三方库文件，整个过程可能耗时数分钟至半小时不等。

感谢您的耐心等待与理解。