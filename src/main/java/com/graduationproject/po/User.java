package com.graduationproject.po;

import java.util.List;

public class User {
    int userid;
    String name;
    String password;
    String idnumber;
    String jurisdicion;
    String phone;
    String job;
    String salary;
    private List<String> permissions; // 用户权限列表

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getJurisdicion() {
        return jurisdicion;
    }

    public void setJurisdicion(String jurisdicion) {
        this.jurisdicion = jurisdicion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
