package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.GradeInfo;
import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.entity.ProjectInfo;
import com.study.gradesInfo.entity.Unit;

import java.util.List;

public interface ProjectService {
    void addProject(Project project);

    void deleteProject(String projectId);

    void updateProject(Project project);

    List<Project> getProjectList();

    Project getProjectById(String projectId);


    String getMatchByProject(String matchId, String projectId);

    List<Project> getProjectByMatchId(String matchId);


    List<Unit> getUnitList();

    Unit getUnit(Unit unit);

    void addUnit(Unit unit);

    void deleteUnit(String unitname);

    GradeInfo getGradeInfo(GradeInfo gradeInfo);

    void addGradeInfo(GradeInfo gradeInfo);

    void deleteGradeInfo(GradeInfo gradeInfo);

    List<GradeInfo> getGradeInfoList(String matchId, String projectId);

    void updateGradeInfo(GradeInfo gradeInfo);

    void updateProjectInfo(ProjectInfo projectInfo);

    ProjectInfo getProjectInfo(String matchId, String projectId);
}
