package com.graduationproject.dao;


import com.graduationproject.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
@Mapper
public interface login {
    public User UserLogin(@Param("name")String name, @Param("password")String password);
}
