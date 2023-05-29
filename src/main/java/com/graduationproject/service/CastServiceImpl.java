package com.graduationproject.service;

import com.graduationproject.po.Cast;
import org.springframework.stereotype.Service;

@Service("CastService")
public class CastServiceImpl implements CastService{
    @Override
    public int deleteByPrimaryKey(Integer castid) {
        return 0;
    }

    @Override
    public int insert(Cast record) {
        return 0;
    }

    @Override
    public int insertSelective(Cast record) {
        return 0;
    }

    @Override
    public Cast selectByPrimaryKey(Integer castid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Cast record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Cast record) {
        return 0;
    }
}
