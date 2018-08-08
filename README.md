# ssh-1
```
ssh整合
  1.struts:mvc框架--->处理用户的请求并给出响应--->action
  2.hibernate:持久层框架--->操作数据库--->dao
  3.spring:
      1.ioc:对象的创和关系的维护
      2.aop
      3.事务控制
  4.spring和web容器整合:spring-web

1.导入依赖
2.编写配置文件:
   1.web.xml
   2.spring.xml
       1.扫包
       2.配置数据源
       3.hibernate会话工厂
       4.事务管理器
       5.配置事务注解驱动
   3.struts配置文件
   4.hibernate配置文件
3.编写各种基类
   1.BaseDao
   2.BaseService
   3.BaseAction      
   ```
