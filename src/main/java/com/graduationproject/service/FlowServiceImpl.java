package com.graduationproject.service;

import com.graduationproject.dao.FlowController;
import com.graduationproject.po.Flow;
import com.graduationproject.po.Materials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FlowService")
public class FlowServiceImpl implements FlowService{
    @Qualifier("flowdao")
    @Autowired
    private FlowController flowService;
    @Override
    public int deleteByPrimaryKey(Integer flowid) {
        flowService.deleteByPrimaryKey(flowid);
        return 0;
    }

    @Override
    public int insert(Flow record) {
        flowService.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(Flow record) {
        return 0;
    }

    @Override
    public Flow selectByPrimaryKey(Integer flowid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Flow record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Flow record) {
        flowService.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<Flow> selectall(int id) {
        List<Flow> flowList = flowService.selectall(id);
        System.out.println(flowList);
        return flowList;
    }
}
