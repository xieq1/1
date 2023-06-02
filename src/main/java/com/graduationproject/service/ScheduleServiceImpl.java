package com.graduationproject.service;

import com.graduationproject.dao.ScheduleController;
import com.graduationproject.po.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ScheduleService")
public class ScheduleServiceImpl implements ScheduleService{
    @Qualifier("scheduledao")
    @Autowired
    private ScheduleController scheduleService;
    @Override
    public int deleteByPrimaryKey(Integer scheduleid) {
        scheduleService.deleteByPrimaryKey(scheduleid);
        return 0;
    }

    @Override
    public int insert(Schedule record) {
        scheduleService.insert(record);
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
        scheduleService.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<Schedule> selectall(int id) {
        List<Schedule> schedulesList = scheduleService.selectall(id);
        System.out.println(schedulesList);
        return schedulesList;
    }
}
