package com.graduationproject.service;

import com.graduationproject.dao.UserController;
import com.graduationproject.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Qualifier("userdao")
    @Autowired
    private UserController userinsert;
    @Override
    public void UserInsert(String name,String password,String jurisdicion,String job,String salary) {
        System.out.print(name);
        userinsert.UserInsert(name,password,jurisdicion,job,salary);
    }
}
