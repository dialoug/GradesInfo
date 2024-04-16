package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.ProjectGrades;

import java.util.List;

public interface ProjectGradesService {

    void addGrade(ProjectGrades projectGrades);

    void addGradeProject(String gradeId, String projectId);

    void deleteGrade(String gradeId);

    void updateGrade(ProjectGrades projectGrades);

    List<ProjectGrades> getGradesList();

    ProjectGrades findGradeByGradeId(String projectId);
}
