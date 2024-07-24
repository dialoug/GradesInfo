package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.*;
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

    @Override
    public String getMatchByProject(String matchId, String projectId) {
        return projectMapper.getMatchByProject(matchId, projectId);
    }

    @Override
    public List<Project> getProjectByMatchId(String matchId) {
        return projectMapper.getProjectByMatchId(matchId);
    }

    @Override
    public List<Unit> getUnitList() {
        return projectMapper.getUnitList();
    }

    @Override
    public Unit getUnit(Unit unit) {
        return projectMapper.getUnit(unit);
    }

    @Override
    public void addUnit(Unit unit) {
        projectMapper.addUnit(unit);
    }

    @Override
    public void deleteUnit(String unitname) {
        projectMapper.deleteUnit(unitname);
    }

    @Override
    public GradeInfo getGradeInfo(GradeInfo gradeInfo) {
        return projectMapper.getGradeInfo(gradeInfo);
    }

    @Override
    public void addGradeInfo(GradeInfo gradeInfo) {
        projectMapper.addGradeInfo(gradeInfo);
    }

    @Override
    public void deleteGradeInfo(GradeInfo gradeInfo) {
        projectMapper.deleteGradeInfo(gradeInfo);
    }

    @Override
    public List<GradeInfo> getGradeInfoList(String matchId, String projectId) {
        return projectMapper.getGradeInfoList(matchId, projectId);
    }

    @Override
    public void updateGradeInfo(GradeInfo gradeInfo) {
        projectMapper.updateGradeInfo(gradeInfo);
    }

    @Override
    public void updateProjectInfo(ProjectInfo projectInfo) {
        projectMapper.updateProjectInfo(projectInfo);
    }

    @Override
    public ProjectInfo getProjectInfo(String matchId, String projectId) {
        return projectMapper.getProjectInfo(matchId, projectId);
    }

    @Override
    public ProjectPoint getProjectPoint(String matchId, String projectId) {
        return projectMapper.getProjectPoint(matchId, projectId);
    }

    @Override
    public void addProjectPoint(ProjectPoint projectPoint) {
        projectMapper.addProjectPoint(projectPoint);
    }

    @Override
    public void updateProjectPoint(ProjectPoint projectPoint) {
        projectMapper.updateProjectPoint(projectPoint);
    }

    @Override
    public String getUnitByMatchIdAndProjectId(String matchId, String projectId) {
        return projectMapper.getUnitByMatchIdAndProjectId(matchId, projectId);
    }

}
