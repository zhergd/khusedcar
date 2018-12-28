package com.khusedcar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author Created by Jobzher
 * @date 2018-11-22 16:15
 */
@Configuration
public class mvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login.html");
    }

    @Override
   public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/user/login","/user/addUser","/user/superAdmin/login","/register.html","/login.html","/css/**","/js/**","/img/**","/vendors/**");
    }
}
