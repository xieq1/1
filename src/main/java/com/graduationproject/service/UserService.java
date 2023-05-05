package com.graduationproject.service;

import com.graduationproject.po.User;

import java.util.List;

public interface UserService {
    void UserInsert(String name,String password,String jurisdicion,String job,String salary);

    int getUserCount();

    List<User> getUsersByPage(int page, int pageSize);
}
