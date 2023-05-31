package com.graduationproject.controller;

import com.graduationproject.po.Materials;
import com.graduationproject.po.Schedule;
import com.graduationproject.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/scheduled")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value="/getscheduleall")
    @ResponseBody
    public List<Schedule> selectall(Schedule schedule){
        return scheduleService.selectall();
    }
}
