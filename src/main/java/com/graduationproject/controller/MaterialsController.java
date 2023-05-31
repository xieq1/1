package com.graduationproject.controller;

import com.graduationproject.po.Materials;
import com.graduationproject.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/materials")
public class MaterialsController {
    @Autowired
    private MaterialsService materialsService;

    @PostMapping(value = "/add")
    public String addNewMaterial(Materials material) {
        int result = materialsService.insertSelective(material);
        return "materialinformation";
    }

    @PostMapping(value = "update")
    public String updatebyid(Materials material){
        materialsService.updateByPrimaryKey(material);
        return "materialinformation";
    }

    @PostMapping(value = "setorderpoint")
    public String updateordbyid(Materials material){
        materialsService.updateByPrimaryKeySelective(material);
        return "materialinformation";
    }
    @PostMapping(value="getmaterialsall")
    @ResponseBody
    public List<Materials> selectall(Materials materials){
        return materialsService.selectall();
    }

    @PostMapping(value = "delectbyid")
    public String delectbyid(Materials material){
        System.out.println(material);
        materialsService.deleteByPrimaryKey(material.getMaterialsid());
        System.out.println(material.getMaterialsid());
        return "materialinformation";
    }
}
