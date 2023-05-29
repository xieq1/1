package com.graduationproject.service;

import com.graduationproject.po.Materials;

import java.util.List;

public interface MaterialsService {
    int deleteByPrimaryKey(Integer materialsid);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(Integer materialsid);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);

    List<Materials> selectall();
}
