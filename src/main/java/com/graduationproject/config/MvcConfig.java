package com.graduationproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final TokenUtil tokenUtil;

    public MvcConfig(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(tokenUtil))
                .addPathPatterns("/user/**");// 添加需要校验 JWT 的路径
    }
}
