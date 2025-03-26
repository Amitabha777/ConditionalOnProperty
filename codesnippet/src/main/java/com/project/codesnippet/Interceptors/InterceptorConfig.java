package com.project.codesnippet.Interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{



     /* 
     ! WebMvcConfigurer provides us AddInterceptor Methods using which we can add the Interceptors
     */



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    
        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/api/**")                 //will add Interceptor to all apis starting after /api
                .excludePathPatterns("/api/auth/**");       //will exclude auth api & will not add Interceptor
    }
 
    
   


}
