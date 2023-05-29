package com.graduationproject.dao;

import com.graduationproject.po.Materials;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository("materialsdao")
@Mapper
public interface MaterialsController {
    int deleteByPrimaryKey(Integer materialsid);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(Integer materialsid);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);

    List<Materials> selectall();
}