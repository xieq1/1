package com.graduationproject.controller;

public class UserDto {
    private int userid;
    private String name;
    private String sex;

    // 省略构造方法、getter和setter方法
    public int getId() {
        return userid;
    }

    public void setId(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
