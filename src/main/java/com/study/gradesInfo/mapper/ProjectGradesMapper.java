package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.ProjectGrades;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectGradesMapper {
    @Insert("")
    public void addGrade(ProjectGrades projectGrades);

    @Insert("")
    public void addGradeProject(String gradeId, String projectId);

    @Delete("")
    public void deleteGrade(String gradeId);

    @Update("")
    public void updateGrade(ProjectGrades projectGrades);

    @Select("")
    public List<ProjectGrades> getAllGrades();

    @Select("")
    public ProjectGrades getGradeBuGradeId(String projectId);
}
