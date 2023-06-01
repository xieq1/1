package com.graduationproject.dao;

import com.graduationproject.po.Flow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("flowdao")
@Mapper
public interface FlowController {
    int deleteByPrimaryKey(Integer flowid);

    int insert(Flow record);

    int insertSelective(Flow record);

    Flow selectByPrimaryKey(Integer flowid);

    int updateByPrimaryKeySelective(Flow record);

    int updateByPrimaryKey(Flow record);

    List<Flow> selectall(Integer id);
}