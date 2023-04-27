package com.graduationproject.service;

import com.graduationproject.dao.login;
import com.graduationproject.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{
    @Qualifier("UserDao")
    @Autowired//不加调用的时候该service为null，会报一个空指针异常的错误
    private login UserDao;
    @Override
    public User Login(String name,String password) {
        //System.out.print(name);
        //System.out.print(password);
        return UserDao.UserLogin(name,password);
    }
}
