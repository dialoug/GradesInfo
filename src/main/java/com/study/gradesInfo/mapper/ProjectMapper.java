package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.GradeInfo;
import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.entity.ProjectInfo;
import com.study.gradesInfo.entity.Unit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("insert into project(name, projectid, isteam,description, date) values (#{name},#{projectId},#{isteam},#{description},now())")
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

    @Select("select * from unit")
    List<Unit> getUnitList();

    @Select("select * from unit where unitname=#{unitname}")
    Unit getUnit(Unit unit);

    @Insert("insert into unit(unitname, description) VALUES (#{unitname},#{description})")
    void addUnit(Unit unit);

    @Delete("delete from unit where unitname=#{unitname}")
    void deleteUnit(String unitname);

    @Select("select * from gradeinfo where matchid=#{matchId} and projectid=#{projectId} and prizename=#{prizeName}")
    GradeInfo getGradeInfo(GradeInfo gradeInfo);

    @Insert("insert into gradeinfo(matchid, projectid, prizename, topranking, underranking, grade) VALUES (#{matchId},#{projectId},#{prizeName},#{topRanking},#{underRanking},#{grade})")
    void addGradeInfo(GradeInfo gradeInfo);

    @Delete("delete from gradeinfo where matchid=#{matchId} and projectid=#{projectId} and prizename=#{prizeName}")
    void deleteGradeInfo(GradeInfo gradeInfo);

    @Select("select * from gradeinfo where matchid=#{matchId} and projectid=#{projectId}")
    List<GradeInfo> getGradeInfoList(String matchId, String projectId);

    @Update("update gradeinfo set topranking=#{topRanking},underranking=#{underRanking},grade=#{grade} where matchid=#{matchId} and projectid=#{projectId} and prizename=#{prizeName}")
    void updateGradeInfo(GradeInfo gradeInfo);

    @Update("update match_project set unit=#{unit},date=#{date} where matchid=#{matchId} and projectid=#{projectId}")
    void updateProjectInfo(ProjectInfo projectInfo);

    @Select("select * from match_project where matchid=#{matchId} and projectid=#{projectId}")
    ProjectInfo getProjectInfo(String matchId, String projectId);
}
