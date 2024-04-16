package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("insert into project(name, projectid, description, date) values (#{name},#{ProjectId},#{description},now())")
    void addProject(Project project);

    @Select("select * from project")
    List<Project> getProjectList();

    @Update("update project set name=#{name},description=#{description} where projectid=#{projectId}")
    void updateProject(Project project);

    @Select("select * from project where projectid=#{projectId}")
    Project getProjectById(String projectId);

    @Delete("delete from project where projectid=#{projectId}")
    void deleteProject(String projectId);
}
