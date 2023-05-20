package com.graduationproject.dao;

import com.graduationproject.po.Cast;

public interface CastController {
    int deleteByPrimaryKey(Integer castid);

    int insert(Cast record);

    int insertSelective(Cast record);

    Cast selectByPrimaryKey(Integer castid);

    int updateByPrimaryKeySelective(Cast record);

    int updateByPrimaryKey(Cast record);
}