package com.graduationproject.service;

import com.graduationproject.po.Materials;

import java.util.Date;
import java.util.List;

public interface MaterialsService {
    int deleteByPrimaryKey(Integer materialsid);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(Integer materialsid);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);

    List<Materials> selectall();

    void updateByPrimaryKeySelective1(String item, Integer purquantity, Date purtime);

    Integer selectByname(String item);

    void insertpur(String item, Integer purquantity, Date purtime);
}
