package com.graduationproject.service.Impl;

import com.graduationproject.dao.ProjectController;
import com.graduationproject.po.Project;
import com.graduationproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {
    @Qualifier("projectdao")
    @Autowired
    private ProjectController projectService;
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

    @Override
    public List<Project> selectall() {
        List<Project> projectList=projectService.selectall();
        System.out.println(projectList);
        return projectList;
    }
}
