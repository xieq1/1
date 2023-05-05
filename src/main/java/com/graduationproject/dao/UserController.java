package com.graduationproject.dao;

import com.graduationproject.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userdao")
@Mapper
public interface UserController {
    public void UserInsert(@Param("name")String name, @Param("password")String password,@Param("jurisdicion")String jurisdicion,@Param("job")String job,@Param("salary")String slary);

    int getUserCount();

    List<User> getUsersByPage(@Param("page") int page, @Param("pageSize") int pageSize);

    List<User> getallUsers();
}
