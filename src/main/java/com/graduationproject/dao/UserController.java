package com.graduationproject.dao;

import com.graduationproject.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userdao")
@Mapper
public interface UserController {
    public void UserInsert(@Param("name")String name, @Param("password")String password,@Param("jurisdicion")String jurisdicion,@Param("job")String job,@Param("salary")String slary);
}
