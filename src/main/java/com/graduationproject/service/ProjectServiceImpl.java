package com.graduationproject.service;

import com.graduationproject.po.Project;
import org.springframework.stereotype.Service;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService{
    @Override
    public int deleteByPrimaryKey(Integer projectid) {
        return 0;
    }

    @Override
    public int insert(Project record) {
        return 0;
    }

    @Override
    public int insertSelective(Project record) {
        return 0;
    }

    @Override
    public Project selectByPrimaryKey(Integer projectid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Project record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Project record) {
        return 0;
    }
}
