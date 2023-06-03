package com.graduationproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final TokenUtil tokenUtil;

    @Autowired
    public LoginInterceptor(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Map<String, String> cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
            request.setAttribute("cookieMap", cookieMap);
        }
        System.out.println(cookies);

        String requestURI = request.getRequestURI();
        if ("/user/login".equals(requestURI)) { // 不拦截登录接口
            return true;
        }
        // 从 Cookie 中获取 Token
        String token = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        System.out.println("Token received: " + token); // 添加调试信息
        if (token != null && !"".equals(token.trim())) { // 如果Token不为空，则进行校验
            if (tokenUtil.validateToken(token)) { // 校验 Token
                return true; // 放行请求
            }
        }

        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // 返回未授权状态码
        return false; // 拦截请求
    }
}