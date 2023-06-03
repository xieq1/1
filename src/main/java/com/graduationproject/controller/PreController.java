package com.graduationproject.controller;

import com.graduationproject.po.Maintainid;
import com.graduationproject.po.Pre;
import com.graduationproject.service.PreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pre")
public class PreController {
    @Autowired
    private PreService preService;
    @PostMapping("/selectallbycid")
    @ResponseBody
    public List<Pre> selectbycid(Integer id){
        return preService.selectbycid(id);
    }
    @PostMapping(value = "/insert")
    public String insert(Pre record)
    {
        record.setPredate(new Date());
        preService.insertSelective(record);
        return "maintain";
    }
    @PostMapping(value = "update")
    public String updatebyid(Pre record){
        preService.updateByPrimaryKeySelective(record);
        return "maintain";
    }

    @PostMapping(value = "delectbyid")
    public String delectbyid(Pre record){
        preService.deleteByPrimaryKey(record.getPreid());
        return "maintain";
    }
}
