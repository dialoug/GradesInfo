package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("insert into project(name, projectid, description, date) values (#{name},#{ProjectId},#{description},now())")
    void addProject(Project project);

    @Select("select * from project")
    List<Project> getProjectList();

    @Update("")
    void updateProject(Project project);

    @Select("")
    Project getProjectById(String projectId);
}
