package com.carrot.testspring.config;

import com.carrot.testspring.component.LoginHandlerInterceptor;
import com.carrot.testspring.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author carrot
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/carrot").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
         WebMvcConfigurer configurer= new WebMvcConfigurer() {
             @Override
             public void addViewControllers(ViewControllerRegistry registry) {
                 registry.addViewController("/").setViewName("login");
                 registry.addViewController("/index.html").setViewName("login");
                 registry.addViewController("/main.html").setViewName("dashboard");
//                 registry.addViewController("/emp/list").setViewName("list");

             }

             @Override
             public void addInterceptors(InterceptorRegistry registry) {
                 registry.addInterceptor(new LoginHandlerInterceptor())
                         .excludePathPatterns("/", "/index", "/index.html", "/user/login", "/asserts/**");
             }
         };
         return configurer;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
