package com.graduationproject.controller;

import com.graduationproject.po.Materials;
import com.graduationproject.po.Purchase;
import com.graduationproject.po.Schedule;
import com.graduationproject.service.MaterialsService;
import com.graduationproject.service.PurchaseService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private MaterialsService materialsService;
    @PostMapping(value = "selectall")
    @ResponseBody
    public List<Purchase> selectall(){
        return purchaseService.selectall();
    }

    @PostMapping(value = "/insert")
    public String insert(Purchase record){
        record.setPurtime(new Date());
        System.out.println(record);
        if(materialsService.selectByname(record.getItem())==null)
        {
            materialsService.insertpur(record.getItem(),record.getPurquantity(),record.getPurtime());
        }
        else
        {
            materialsService.updateByPrimaryKeySelective1(record.getItem(),record.getPurquantity(),record.getPurtime());
        }
        purchaseService.insert(record);
        return "purchase";
    }

    @PostMapping(value = "/deletebyid")
    public String delect(Integer id){
        purchaseService.deleteByPrimaryKey(id);
        return "purchase";
    }
}
