package com.graduationproject.controller;

import com.graduationproject.po.Flow;
import com.graduationproject.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
