package com.gn3.kpc.localnews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login_form").setViewName("user/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
//                .allowedOrigins("http://127.0.0.1:5500", "http://127.0.0.1:9000", "http://127.0.0.1:8081", "http://localhost:8081")
                .allowedMethods("*");
//                .allowCredentials(true);
    }

}