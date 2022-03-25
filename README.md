## 组织结构

``` lua
foodie-dev
├── foodie-common       -- 工具类及通用代码模块
├── foodie-monitor 8801 -- 基于Spring Boot Admin的微服务监控中心
├── foodie-auth    8802 -- 基于Spring Security Oauth2的统一的认证中心
├── foodie-user    8803 -- 用户中心
├── foodie-pass    8804 -- SSO单点登录
├── foodie-gateway 8805 -- 网关服务
├── foodie-admin   8806 -- 后台管理系统服务
├── foodie-pay     8807 -- 支付平台
├── foodie-portal  8808 -- 移动端商城系统服务
├── foodie-logging 8809 -- 为系统的日志模块，其他模块如果需要记录日志需要引入该模块
├── foodie-demo -- 微服务远程调用测试服务
└── config -- 配置中心存储的配置
```
