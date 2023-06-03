package com.graduationproject.service.Impl;

import com.graduationproject.dao.PreController;
import com.graduationproject.po.Pre;
import com.graduationproject.service.PreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PreService")
public class PreServiceImpl implements PreService {
    @Qualifier("predao")
    @Autowired
    private PreController predao;
    @Override
    public int deleteByPrimaryKey(Integer preid) {
        predao.deleteByPrimaryKey(preid);
        return 0;
    }

    @Override
    public int insert(Pre record) {
        return 0;
    }

    @Override
    public int insertSelective(Pre record) {
        predao.insertSelective(record);
        return 0;
    }

    @Override
    public Pre selectByPrimaryKey(Integer preid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Pre record) {
        predao.updateByPrimaryKeySelective(record);
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Pre record) {
        return 0;
    }

    @Override
    public List<Pre> selectbycid(Integer id) {
        List<Pre> preList=predao.selectbycid(id);
        return preList;
    }
}
