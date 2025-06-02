package com.cyro.demo_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class AppConfig implements WebMvcConfigurer {
//
//    @Autowired
//    CustomInterceptor customInterceptor;
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(customInterceptor)
//                .addPathPatterns("/api/*")
//                .excludePathPatterns("/api/updateUser", "/api/deleteUser");
//    }
//}
