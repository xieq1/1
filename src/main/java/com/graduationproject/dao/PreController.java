package com.graduationproject.dao;

import com.graduationproject.po.Pre;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("predao")
@Mapper
public interface PreController {
    int deleteByPrimaryKey(Integer preid);

    int insert(Pre record);

    int insertSelective(Pre record);

    Pre selectByPrimaryKey(Integer preid);

    int updateByPrimaryKeySelective(Pre record);

    int updateByPrimaryKey(Pre record);

    List<Pre> selectbycid(Integer id);
}