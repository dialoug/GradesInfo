package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.Project;

import java.util.List;

public interface ProjectService {
    void addProject(Project project);

    List<Project> getProjectList();
}
