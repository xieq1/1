package com.graduationproject.controller;

import com.graduationproject.po.Maintainid;
import com.graduationproject.po.Materials;
import com.graduationproject.po.Schedule;
import com.graduationproject.service.MatintainidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/maintainid")
public class MatintainidController {
    @Autowired
    private MatintainidService matintainidService;

    @PostMapping("/selectallbycid")
    @ResponseBody
    public List<Maintainid> selectbycid(Integer id){
        return matintainidService.selectbycid(id);
    }

    @PostMapping(value = "/insert")
    public String insert(Maintainid record)
    {
        record.setMadate(new Date());
        matintainidService.insertSelective(record);
        return "maintain1";
    }

    @PostMapping(value = "update")
    public String updatebyid(Maintainid record){
        matintainidService.updateByPrimaryKeySelective(record);
        return "maintain1";
    }

    @PostMapping(value = "delectbyid")
    public String delectbyid(Maintainid record){
        matintainidService.deleteByPrimaryKey(record.getMaintainid());
        return "maintain1";
    }
}
