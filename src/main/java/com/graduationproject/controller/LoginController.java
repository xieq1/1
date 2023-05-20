package com.graduationproject.controller;

import com.graduationproject.config.TokenUtil;
import com.graduationproject.po.User;
import com.graduationproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
/*  @PostMapping(value = "/login")
    public String login(HttpServletRequest request,User u){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        System.out.print(name);
        System.out.print(password);
        if(name.equals("admin")&&password.equals("123456"))
            return "index";
        u = loginService.Login(name,password);
        //int i=0;
        if(u!=null) {
            return "index";
        }
        return "login";

@GetMapping("/login")
    public String login() {
        return "login";
    }
}*/

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
            cookie.setMaxAge(300);
            response.addCookie(cookie);
            System.out.print(token);
            // 跳转到首页，并将Token作为URL参数之一
            response.sendRedirect(request.getContextPath() +"/user/index?token=" + token);
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
