package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("insert into project(name, projectid, description, date) values (#{name},#{projectId},#{description},now())")
    void addProject(Project project);

    @Select("select * from project")
    List<Project> getProjectList();

    @Update("update project set name=#{name},description=#{description} where projectid=#{projectId}")
    void updateProject(Project project);

    @Select("select * from project where projectid=#{projectId}")
    Project getProjectById(String projectId);

    @Delete("delete from project where projectid=#{projectId}")
    void deleteProject(String projectId);

    @Select("select matchid from match_project where matchid=#{matchId} and projectid=#{projectId}")
    String getMatchByProject(String matchId, String projectId);

    @Select("select * from project where projectid in (select projectid from match_project where matchid=#{matchId})")
    List<Project> getProjectByMatchId(String matchId);
}
