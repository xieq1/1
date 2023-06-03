package com.graduationproject.service;

import com.graduationproject.dao.MaintainidController;
import com.graduationproject.po.Maintainid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MatintainidService")
public class MatintainidServiceImpl implements MatintainidService{
    @Qualifier("maintainiddao")
    @Autowired
    private MaintainidController maintainidService;
    @Override
    public int deleteByPrimaryKey(Integer maintainid) {
        maintainidService.deleteByPrimaryKey(maintainid);
        return 0;
    }

    @Override
    public int insert(Maintainid record) {
        return 0;
    }

    @Override
    public int insertSelective(Maintainid record) {
        maintainidService.insertSelective(record);
        return 0;
    }

    @Override
    public Maintainid selectByPrimaryKey(Integer maintainid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Maintainid record) {
        maintainidService.updateByPrimaryKeySelective(record);
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Maintainid record) {
        maintainidService.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<Maintainid> selectbycid(Integer id) {
        List<Maintainid> maintainidList=maintainidService.selectbycid(id);
        return maintainidList;
    }
}
