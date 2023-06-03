package com.graduationproject.controller;

import com.graduationproject.po.Flow;
import com.graduationproject.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("flow")
public class FlowController {
    @Autowired
    private FlowService flowService;

    @PostMapping(value = "getflowall")
    @ResponseBody
    public List<Flow> selectall(Integer id){
        return flowService.selectall(id);
    }

    @PostMapping(value = "delectbyid")
    public String delectbyid(Flow record){
        flowService.deleteByPrimaryKey(record.getFlowid());
        return "process";
    }

    @PostMapping(value = "update")
    public String updatebyid(Flow record){
        flowService.updateByPrimaryKey(record);
        return "process";
    }

    @PostMapping(value = "update1")
    public String updatebyid1(Flow record){
        System.out.println(record);
        flowService.updateByPrimaryKeySelective(record);
        return "process";
    }

    @PostMapping(value = "/insert")
    public String insert(Flow record){
        flowService.insert(record);
        return "process";
    }
}
