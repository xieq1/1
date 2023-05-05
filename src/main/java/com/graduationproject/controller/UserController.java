package com.graduationproject.controller;

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
}
