package com.graduationproject.dao;

import com.graduationproject.po.Maintainid;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("maintainiddao")
@Mapper
public interface MaintainidController {
    int deleteByPrimaryKey(Integer maintainid);

    int insert(Maintainid record);

    int insertSelective(Maintainid record);

    Maintainid selectByPrimaryKey(Integer maintainid);

    int updateByPrimaryKeySelective(Maintainid record);

    int updateByPrimaryKey(Maintainid record);

    List<Maintainid> selectbycid(Integer id);
}