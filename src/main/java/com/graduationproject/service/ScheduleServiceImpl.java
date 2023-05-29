package com.graduationproject.service;

import com.graduationproject.po.Schedule;
import org.springframework.stereotype.Service;

@Service("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService{
    @Override
    public int deleteByPrimaryKey(Integer scheduleid) {
        return 0;
    }

    @Override
    public int insert(Schedule record) {
        return 0;
    }

    @Override
    public int insertSelective(Schedule record) {
        return 0;
    }

    @Override
    public Schedule selectByPrimaryKey(Integer scheduleid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Schedule record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Schedule record) {
        return 0;
    }
}
