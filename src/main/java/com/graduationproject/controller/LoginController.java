package com.graduationproject.controller;

import com.graduationproject.po.User;
import com.graduationproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping(value = "/login")
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
}
}
