# spring-boot-security-oauth2

## 什么是 oAuth
oAuth 协议为用户资源的授权提供了一个安全的、开放而又简易的标准。与以往的授权方式不同之处是 oAuth 的授权不会使第三方触及到用户的帐号信息（如用户名与密码），即第三方无需使用用户的用户名与密码就可以申请获得该用户资源的授权，因此 oAuth 是安全的。

## 什么是 Spring Security
Spring Security 是一个安全框架，前身是 Acegi Security，能够为 Spring 企业应用系统提供声明式的安全访问控制。Spring Security 基于 Servlet 过滤器、IoC 和 AOP，为 Web 请求和方法调用提供身份确认和授权处理，避免了代码耦合，减少了大量重复代码工作。

## 请求流程
1. 用户打开客户端（PC、安卓、IOS），客户端向认证服务器发起请求，要求用户给与授权；
2. 认证服务器返回鉴权页面（登录页面，QQ登录，微信登录，客户端自己的账号密码登录）；
3. 用户在客户端输入用户名/密码，或者使用QQ、微信登录，请求认证服务器，并同意授权给客户端授权；
```http://localhost:8080/oauth/authorize?client_id=client&response_type=code```
4. 认证服务器返回一个code授权码给客户端；
5. 客户端向认证服务器申请令牌（token），客户端拿着client_id，code授权码，授权模式等信息访问认证服务器；
```http://client:secret@localhost:8080/oauth/token```
6. 认证服务器验证成功后给客户端发放令牌（token）；
7. 客户端通过携带token来访问资源服务器拿到资源展示给用户；
```http://localhost:8081/contents?access_token=yourAccessToken```