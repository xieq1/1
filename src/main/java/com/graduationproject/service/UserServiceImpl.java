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
    public void UserInsert(String name,String password,String jurisdicion,String job,String salary) {
        System.out.print(name);
        userservice.UserInsert(name,password,jurisdicion,job,salary);
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
}
