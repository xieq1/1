package com.graduationproject.service;

import com.graduationproject.dao.CastController;
import com.graduationproject.po.Cast;
import com.graduationproject.po.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CastService")
public class CastServiceImpl implements CastService{
    @Qualifier("castdao")
    @Autowired
    private CastController castService;
    @Override
    public int deleteByPrimaryKey(Integer castid) {
        castService.deleteByPrimaryKey(castid);
        return 0;
    }

    @Override
    public int insert(Cast record) {
        castService.insert(record);
        return 0;
    }

    @Override
    public int insertSelective(Cast record) {
        return 0;
    }

    @Override
    public Cast selectByPrimaryKey(Integer castid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Cast record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Cast record) {
        castService.updateByPrimaryKey(record);
        return 0;
    }

    @Override
    public List<Cast> selectall() {
        List<Cast> castList = castService.selectall();
        System.out.println(castList);
        return castList;
    }
}
