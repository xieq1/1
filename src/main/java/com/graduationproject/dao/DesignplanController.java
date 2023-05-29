package com.graduationproject.dao;

import com.graduationproject.po.Designplan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("designplandao")
@Mapper
public interface DesignplanController {
    int deleteByPrimaryKey(Integer designplanid);

    int insert(Designplan record);

    int insertSelective(Designplan record);

    Designplan selectByPrimaryKey(Integer designplanid);

    int updateByPrimaryKeySelective(Designplan record);

    int updateByPrimaryKey(Designplan record);
}