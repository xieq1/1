package com.graduationproject.service;

import com.graduationproject.po.Flow;
import com.graduationproject.po.Materials;

import java.util.List;

public interface FlowService {
    int deleteByPrimaryKey(Integer flowid);

    int insert(Flow record);

    int insertSelective(Flow record);

    Flow selectByPrimaryKey(Integer flowid);

    int updateByPrimaryKeySelective(Flow record);

    int updateByPrimaryKey(Flow record);

    List<Flow> selectall();
}
