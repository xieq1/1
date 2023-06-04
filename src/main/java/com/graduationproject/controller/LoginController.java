package com.graduationproject.controller;

import com.graduationproject.config.TokenUtil;
import com.graduationproject.po.User;
import com.graduationproject.service.LoginService;
import com.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = loginService.Login(name, password);

        if (user != null) {
            // 生成并存储Token
            String token = tokenUtil.generateToken(String.valueOf(user.getUserid()));
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            cookie.setSecure(true); // 启用 HTTPS 时发送 Cookie
            cookie.setPath("/"); // 设置 Cookie 的作用域路径为应用程序的上下文路径
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() +"/user/index");
        } else {
            // 登录失败，重新登录
            response.sendRedirect(request.getContextPath() +"/login?error=用户名或密码错误！");
        }
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
