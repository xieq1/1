package com.graduationproject.dao;

import com.graduationproject.po.Maintainid;

public interface MaintainidController {
    int deleteByPrimaryKey(Integer maintainid);

    int insert(Maintainid record);

    int insertSelective(Maintainid record);

    Maintainid selectByPrimaryKey(Integer maintainid);

    int updateByPrimaryKeySelective(Maintainid record);

    int updateByPrimaryKey(Maintainid record);
}