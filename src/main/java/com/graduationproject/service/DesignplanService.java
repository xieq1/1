package com.graduationproject.service;

import com.graduationproject.po.Designplan;

public interface DesignplanService {
    int deleteByPrimaryKey(Integer designplanid);

    int insert(Designplan record);

    int insertSelective(Designplan record);

    Designplan selectByPrimaryKey(Integer designplanid);

    int updateByPrimaryKeySelective(Designplan record);

    int updateByPrimaryKey(Designplan record);
}
