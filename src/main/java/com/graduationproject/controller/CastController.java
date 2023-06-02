package com.graduationproject.controller;

import com.graduationproject.po.Cast;
import com.graduationproject.po.Flow;
import com.graduationproject.po.Schedule;
import com.graduationproject.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("cast")
public class CastController {
    @Autowired
    private CastService castService;

    @PostMapping(value="getcastall")
    @ResponseBody
    public List<Cast> selectall(Cast cast){
        return castService.selectall();
    }

    @PostMapping(value = "/insert")
    public String insert(Cast record){
        castService.insert(record);
        return "slary";
    }

    @PostMapping(value = "/update")
    public String update(Cast record){
        castService.updateByPrimaryKey(record);
        return "slary";
    }

    @PostMapping(value = "delectbyid")
    public String delectbyid(Cast record){
        castService.deleteByPrimaryKey(record.getCastid());
        return "slary";
    }
}
