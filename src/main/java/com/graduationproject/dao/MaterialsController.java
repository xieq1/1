package com.graduationproject.dao;

import com.graduationproject.po.Materials;

public interface MaterialsController {
    int deleteByPrimaryKey(Integer materialsid);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(Integer materialsid);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);
}