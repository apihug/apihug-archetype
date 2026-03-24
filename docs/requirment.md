
This is a rapid develop application template for the apihug platform 


1. the `refer` contains two example project:
   1. jhipster example, I need you refer some good example in the `com.big.sample.web.rest` how to management the account and authenticate,  BUT apihug not use the spring security
2. `RuoYi-Vue-Plus` in its `ruoyi-modules/ruoyi-system` which has perfect implementation for the system level resources like, dict, Menu, Role etc


现在这个项目核心就是做基础设施

1. 多住户管理
2. 平台管理
3. 菜单管理
4. RBAC 管理
5. 访问日记管理
6. 角色和资源管理

但是像菜单和静态资源， APIHUG 天生支持多住户管理， 还有api meta 信息管理， 你可以从 `rad-app\src\main\resources\rad-app\com\apihug` 下面的

apihug.json
entities.json
hope-domain-authorities.json
hope-domain-dictionaries.json
hope-domain-errors.json
hope-project-meta.json

看到这这些基本信息， 包括API， 常量，错误码这些

同时这个项目里面已经实现了基本 customer(user, apihug 没有歧义的user, customer 其实就是user), audit 管理
你可以 `rad-app\src\main\proto` 里面的视线 同时 `rad-app\src\main\java` 里面也有也有。

我需要梳理， 然后开发和完善这部分的 api  和功能， 将这个项目变成一个 标准 RAD 模版， 这样子可以避免很多开发工作。

