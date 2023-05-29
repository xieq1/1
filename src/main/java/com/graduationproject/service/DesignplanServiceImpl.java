package com.graduationproject.service;

import com.graduationproject.po.Designplan;
import org.springframework.stereotype.Service;

@Service("DesignplanService")
public class DesignplanServiceImpl implements DesignplanService{
    @Override
    public int deleteByPrimaryKey(Integer designplanid) {
        return 0;
    }

    @Override
    public int insert(Designplan record) {
        return 0;
    }

    @Override
    public int insertSelective(Designplan record) {
        return 0;
    }

    @Override
    public Designplan selectByPrimaryKey(Integer designplanid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Designplan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Designplan record) {
        return 0;
    }
}
