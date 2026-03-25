package com.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
   
   @Autowired
   private LoginCheckInterceptor loginChechInterceptor;
   
   @Override
   public void addInterceptors(InterceptorRegistry registry) {


      registry.addInterceptor(loginChechInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns( //제외하는 거
                  "/", 
                  "/loginForm",
                  "/memoList",
                  "/login",
                  "/.well-known/**");
            
   }
   
   
}