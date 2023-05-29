package com.graduationproject.dao;

import com.graduationproject.po.Cast;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("castdao")
@Mapper
public interface CastController {
    int deleteByPrimaryKey(Integer castid);

    int insert(Cast record);

    int insertSelective(Cast record);

    Cast selectByPrimaryKey(Integer castid);

    int updateByPrimaryKeySelective(Cast record);

    int updateByPrimaryKey(Cast record);
}