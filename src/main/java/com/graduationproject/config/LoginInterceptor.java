package com.graduationproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final TokenUtil jwtUtils;

    @Autowired
    public LoginInterceptor(TokenUtil jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if ("/user/login".equals(requestURI)) { // 不拦截登录接口
            return true;
        }
        String token = request.getParameter("token"); // 获取Token参数
        System.out.println("Token received: " + token); // 添加调试信息
        if (token != null && !"".equals(token.trim())) { // 如果Token不为空，则进行校验
            if (jwtUtils.validateToken(token)) { // 校验 Token
                return true; // 放行请求
            }
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // 返回未授权状态码
        return false; // 拦截请求
    }
}