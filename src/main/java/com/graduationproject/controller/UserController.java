package com.graduationproject.controller;

import com.graduationproject.config.TokenUtil;
import com.graduationproject.po.User;
import com.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.net.PasswordAuthentication;

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
        userService.UserInsert(u.getName(),u.getPassword(),u.getJurisdicion(),u.getJob(),u.getSalary());
        return "index";
    }

    @GetMapping("/getalluser")
    public String getAllUsers(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10; // 每页显示10条记录

        // 查询总记录数
        int totalCount = userService.getUserCount();

        // 计算总页数
        int totalPages = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);

        // 查询当前页的用户信息
        List<User> users = userService.getUsersByPage(page, pageSize);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "staffinformation"; // 返回视图名称
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
