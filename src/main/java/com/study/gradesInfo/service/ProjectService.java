package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.Project;

import java.util.List;

public interface ProjectService {
    void addProject(Project project);

    void deleteProject(String projectId);

    void updateProject(Project project);

    List<Project> getProjectList();

    Project getProjectById(String projectId);


    String getMatchByProject(String matchId, String projectId);

    List<Project> getProjectByMatchId(String matchId);
}
