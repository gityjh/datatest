package com.example.datatest.haoyue.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration =registry.addInterceptor(new LoginHandlerInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/login/*",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/**/*.gif",
                "/**/*.ico");//添加不被拦截的路径,有很多静态资源
    }
}
