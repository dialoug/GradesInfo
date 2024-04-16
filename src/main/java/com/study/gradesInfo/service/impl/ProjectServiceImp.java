package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.mapper.ProjectMapper;
import com.study.gradesInfo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void addProject(Project project) {
        projectMapper.addProject(project);
    }

    @Override
    public void deleteProject(String projectId) {
        projectMapper.deleteProject(projectId);
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateProject(project);
    }

    @Override
    public List<Project> getProjectList() {
        List<Project> projects = projectMapper.getProjectList();
        return projects;
    }


    @Override
    public Project getProjectById(String projectId) {
        return projectMapper.getProjectById(projectId);
    }

}
