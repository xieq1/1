package com.graduationproject.service;

import com.graduationproject.dao.UserController;
import com.graduationproject.po.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.google.common.collect.ImmutableMap;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Qualifier("userdao")
    @Autowired
    private UserController userservice;
    private SqlSessionTemplate sqlSession;
    @Override
    public void UserInsert(String name, String password, String role, String job, String salary) {
        //System.out.print(name);
        userservice.UserInsert(name,password, role,job,salary);
    }

    @Override
    public void updatebyuid(int userid, String name, String password, String role, String job, String salary) {
        userservice.updatebyuid(userid,name,password,role,job,salary);
    }

    @Override
    public int getUserCount() {
        return userservice.getUserCount();
    }

    @Override
    public List<User> getUsersByPage(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return sqlSession.selectList("getUsersByPage",ImmutableMap.of("pageSize", pageSize, "offset", offset));
    }

    @Override
    public User findById(int userId) {
        return userservice.findbyid(userId);
    }

    public List<User> getAllUsers() {
        List<User> userList = userservice.selectall();
        //System.out.println(userList);
        return userList;
    }

    @Override
    public void delectbyuid(int userid) {
        userservice.delectbyuid(userid);
    }
}
