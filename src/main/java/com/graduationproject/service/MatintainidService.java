package com.graduationproject.service;

import com.graduationproject.po.Maintainid;

import java.util.List;

public interface MatintainidService {
    int deleteByPrimaryKey(Integer maintainid);

    int insert(Maintainid record);

    int insertSelective(Maintainid record);

    Maintainid selectByPrimaryKey(Integer maintainid);

    int updateByPrimaryKeySelective(Maintainid record);

    int updateByPrimaryKey(Maintainid record);

    List<Maintainid> selectbycid(Integer id);
}
