package com.graduationproject.controller;

import com.graduationproject.po.Project;
import com.graduationproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "getprojectall")
    @ResponseBody
    public List<Project> selectall(){
        return projectService.selectall();
    }
}
