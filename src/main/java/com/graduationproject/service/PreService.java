package com.graduationproject.service;

import com.graduationproject.po.Pre;

import java.util.List;

public interface PreService {
    int deleteByPrimaryKey(Integer preid);

    int insert(Pre record);

    int insertSelective(Pre record);

    Pre selectByPrimaryKey(Integer preid);

    int updateByPrimaryKeySelective(Pre record);

    int updateByPrimaryKey(Pre record);

    List<Pre> selectbycid(Integer id);
}
