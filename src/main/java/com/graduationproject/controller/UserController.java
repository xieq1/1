package com.graduationproject.controller;

import com.graduationproject.config.TokenUtil;
import com.graduationproject.po.User;
import com.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    @GetMapping("/getalluser")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/topersonalinformation")
    public String getProfile(HttpServletRequest request, Model model) {
        // 从请求中获取Token参数
        String token = request.getParameter("token");
        System.out.println("Token: " + token); // 添加调试记录
        if (token == null || token.isEmpty()) {
            // 如果Token为空，则重定向到登录页面
            return "personalinformation";
        }

        // 验证Token的有效性，并返回用户ID
        String userId = tokenUtil.getUserIdFromToken(token);
        if (userId == null || userId.isEmpty()) {
            // 如果Token无效，则重定向到登录页面
            return "personalinformation";
        }

        // 根据用户ID获取用户信息
        User user = userService.findById(Integer.parseInt(userId));
        if (user == null) {
            // 如果未找到用户，则重定向到登录页面
            return "personalinformation";
        }

        // 将用户信息存储到模型中，并渲染视图
        model.addAttribute("user", user);
        return "personalinformation";
    }
}
