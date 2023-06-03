package com.graduationproject.service.Impl;

import com.graduationproject.dao.MaterialsController;
import com.graduationproject.po.Materials;
import com.graduationproject.po.User;
import com.graduationproject.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("MaterialsService")
public class MaterialsServiceImpl implements MaterialsService {
    @Qualifier("materialsdao")
    @Autowired
    private MaterialsController materialsService;
    @Override
    public int deleteByPrimaryKey(Integer materialsid) {
        System.out.println(materialsid);
        materialsService.deleteByPrimaryKey(materialsid);
        return 0;
    }

    @Override
    public int insert(Materials record) {
        return 0;
    }

    @Override
    public int insertSelective(Materials record) {
        int i=materialsService.insertSelective(record);
        return i;
    }

    @Override
    public Materials selectByPrimaryKey(Integer materialsid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Materials record) {
        System.out.println(record);
        materialsService.updateByPrimaryKeySelective(record);
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Materials record) {
        System.out.println(record);
        materialsService.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<Materials> selectall() {
        List<Materials> materialsList = materialsService.selectall();
        System.out.println(materialsList);
        return materialsList;
    }

    @Override
    public void updateByPrimaryKeySelective1(String item, Integer purquantity, Date purtime) {
        materialsService.updateByPrimaryKeySelective1(item,purquantity,purtime);
    }

    @Override
    public Integer selectByname(String item) {
        return materialsService.selectbyname(item);
    }

    @Override
    public void insertpur(String item, Integer purquantity, Date purtime) {
        materialsService.insertpur(item,purquantity,purtime);
    }
}
