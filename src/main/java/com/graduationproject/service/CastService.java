package com.graduationproject.service;

import com.graduationproject.po.Cast;

import java.util.List;

public interface CastService {
    int deleteByPrimaryKey(Integer castid);

    int insert(Cast record);

    int insertSelective(Cast record);

    Cast selectByPrimaryKey(Integer castid);

    int updateByPrimaryKeySelective(Cast record);

    int updateByPrimaryKey(Cast record);

    List<Cast> selectall();
}
