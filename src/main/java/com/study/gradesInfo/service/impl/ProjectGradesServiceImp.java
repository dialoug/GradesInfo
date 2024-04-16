package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.ProjectGrades;
import com.study.gradesInfo.mapper.ProjectGradesMapper;
import com.study.gradesInfo.service.ProjectGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectGradesServiceImp implements ProjectGradesService {
    @Autowired
    ProjectGradesMapper projectGradesMapper;

    @Override
    public void addGrade(ProjectGrades projectGrades) {
        projectGradesMapper.addGrade(projectGrades);
    }

    @Override
    public void addGradeProject(String gradeId, String projectId) {
        projectGradesMapper.addGradeProject(gradeId, projectId);
    }

    @Override
    public void deleteGrade(String gradeId) {
        projectGradesMapper.deleteGrade(gradeId);
    }

    @Override
    public void updateGrade(ProjectGrades projectGrades) {
        projectGradesMapper.updateGrade(projectGrades);
    }

    @Override
    public List<ProjectGrades> getGradesList() {
        return projectGradesMapper.getAllGrades();
    }

    @Override
    public ProjectGrades findGradeByGradeId(String projectId) {
        return projectGradesMapper.getGradeBuGradeId(projectId);
    }


}
