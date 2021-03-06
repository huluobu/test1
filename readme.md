git is a distributed version control system
git is sf under the gpl
git tracks changes
git merge
new machsim

---------
##字面量

-‘’：会转义特殊字符
-“”：不会转义特殊字符


##log

###slf4和log4

1. 前者是通用接口门面，后者是日志框架的具体实现

2. slf4何以和 其他的日志框架进行融合

3. 日志文件的配置

```	java
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
```
4. 日志级别
	trace-debug-info-warn-error

5. 在properties中默认配置logging.path的设定，格式的设定

6. log日志的指定配置，在/resource文件的logback.xml or logback-spring.xml(多环境的日志配置)

7. 日志框架具体实现的替换，log4j切换log4j2

##web开发
####资源映射
1. 静态资源映射

/webjars/**,在 META-INF/resource/webjars寻找资源

2. 特定资源配置

- /META-INF/resource/  
- /static/  
- /public/ 
   
3. 欢迎页的设置index.html在static下

####引擎模板
1.thyleaf使用，首先引入依赖  
``` xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
```
2.thyleaf语法使用  
    - 导入名称空间：xmlns:th="http://www.thymeleaf.org"
``` html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org>">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>成功</h1>
    <p th:text="${hello}">Welcome to our grocery store!</p>
</body>
</html>
```
``` html
<div th:object="${session.user}">
<p>Name: <span th:text="*{firstName}">Sebastian</span>.</p>
<p>Surname: <span th:text="*{lastName}">Pepper</span>.</p>
<p>Nationality: <span th:text="*{nationality}">Saturn</span>.</p>
</div>
```
####spring mvc使用
1. 修改默认配置，在自动配置组件时，先查看组件是否存在，如果不存在，先创建自己的默认配置
    或者。
2. 编写自己的配置类，implements WebMvcConfigurer接口，重写相应的方法
``` java
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/carrot").setViewName("success");
    }
}
```
如果加上@enablewebmvc默认配置会失效  
####restfulcrud使用
* **加载自己的index页面**
``` java
 @Bean
    public WebMvcConfigurer webMvcConfigurer(){
         WebMvcConfigurer configurer= new WebMvcConfigurer() {
             @Override
             public void addViewControllers(ViewControllerRegistry registry) {
                 registry.addViewController("/").setViewName("login");
                 registry.addViewController("/index.html").setViewName("login");
             }
         };
         return configurer;
```
* **国际化配置**设置国际化文件配置的路径spring.messages.basename=i18n.login    
根据请求头解析区域信息解析器
``` java 
login.btm=登录
login.password=密码
login.rememberme=记住我
login.tip=请登录
login.username=用户名
```
创建本地的locale 解析器
``` java
public class MyLocalResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l =httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split=l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
```
mvc配置中加入解析器
``` java
@Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
```
*  **登录**  
1). 禁止thmyleaf缓存
``` java
spring.thymeleaf.cache=false
```
2). input标签页设置
``` html
<input type="text" name="username"
```
3). 拦截器登录检查
``` java
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("loginUser");
        if(user == null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
```
mymvcconfig注册拦截器
``` java
public void addInterceptors(InterceptorRegistry registry) {
                 registry.addInterceptor(new LoginHandlerInterceptor())
                         .excludePathPatterns("/", "/index", "/index.html", "/user/login", "/asserts/**");
             }
         };
```
4) CRUD员工列表实现
1. 确定跳转请求 /get /post /emp 等等；   
2. 填写控制器 @getmapping  or @postmapping
3. 注意html中form表单只支持GET与POST请求，而DELETE、PUT等method并不支持，spring3添加了一个过滤器，可以将这些请求转换为标准的http方法，使得支持GET、POST、PUT与DELETE请求。 
4. 由源码可以看出，filter只对Post方法进行过滤，且需要添加参数名为_method的隐藏域，也可以设置其他参数名，比如想设置为_method_，可以在HiddenHttpMethodFilter配置类中设置初始化参数：put (methodParam,"_method_")  


https://blog.csdn.net/liuweilong07/article/details/80396055?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1




