package com.graduationproject.controller;

import com.graduationproject.config.TokenUtil;
import com.graduationproject.po.User;
import com.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtil tokenUtil;
    @PostMapping(value = "/insert")
    public String Userinsert(HttpServletRequest request,User u)
    {
        userService.UserInsert(u.getName(),u.getPassword(),u.getRole(),u.getJob(),u.getSalary());
        return "staffinformation";
    }

    @PostMapping(value = "/updatebyid")
    public String updatebyuid(HttpServletRequest request,User u)
    {
        userService.updatebyuid(u.getUserid(),u.getName(),u.getPassword(),u.getRole(),u.getJob(),u.getSalary());
        return "staffinformation";
    }

    @PostMapping(value = "/delectbyid")
    public String delectbyuid(HttpServletRequest request,User u)
    {
        userService.delectbyuid(u.getUserid());
        return "staffinformation";
    }

    @GetMapping("/getalluser")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/topersonalinformation")
    public String getProfile(HttpServletRequest request, Model model) {
        String userId=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Map<String, String> cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
            request.setAttribute("cookieMap", cookieMap);
        }
        System.out.println(cookies);
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
        if (token != null && !"".equals(token.trim())) { // 如果 Token 不为空，则进行校验
            if (tokenUtil.validateToken(token)) { // 校验 Token
                userId = tokenUtil.getUserIdFromToken(token);
            }
        }
        System.out.println(userId);
        if (userId == null || userId.isEmpty()) {
            // 如果未找到有效的用户 ID 或角色，则重定向到登录页面
            return "personalinformation";
        }
        // 根据用户ID获取用户信息
        User user = userService.findById(Integer.parseInt(userId));
        if (user.getUserid() == 0) {
            // 如果未找到用户，则重定向到登录页面
            return "personalinformation";
        }

        // 将用户信息存储到模型中，并渲染视图
        model.addAttribute("user", user);
        return "personalinformation";
    }
}
