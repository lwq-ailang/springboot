## springboot
  # 1.三种方式连接数据库：
        方式一：与JdbcTemplate集成
        方式二：与JPA集成
        方式三：与MyBatis集成
  # 2.Scheduled定时任务：
        staticScheduled：静态定时使用注解
        dynamicScheduled：动态定时使用接口
        threadScheduled：线程定时   
  # 3.mybatis使用 
        
  # 4.Profile使用：
      为不同环境下使用不同的配置提供了支持（开发环境和生成环境)，通过设定Environment的ActiveProfiles类设定当前context需要使用的配置。在开发中使用  @Profile注解类或者方法，达到不同情况下选择实例化不同的Bean。通过设定JVM的spring.profiles.active参数来设计配置环境。Web项目设置在Servlet的context parameter中。
  # 5.Annotation使用：
      元注解：可以注解到别的注解上的注解。组合注解：被注解注解的注解称为 组合注解；组合注解具备元注解的功能。
  
