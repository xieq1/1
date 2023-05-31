package com.graduationproject.service;

import com.graduationproject.po.User;

import java.util.List;

public interface UserService {
    void UserInsert(String name, String password, String role, String job, String salary);

    void updatebyuid(int userid,String name, String password, String role, String job, String salary);

    int getUserCount();

    List<User> getUsersByPage(int page, int pageSize);

    User findById(int userId);

    List<User> getAllUsers();

    void delectbyuid(int userid);
}
