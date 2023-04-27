package com.graduationproject.controller;

import com.graduationproject.po.User;
import com.graduationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
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
}
