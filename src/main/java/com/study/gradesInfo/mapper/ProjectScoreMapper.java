package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.ProjectScore;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectScoreMapper {

    @Select("select * from transcripts")
    public List<ProjectScore> getAllScore();

    @Select("select * from transcripts where matchid=#{matchId} and studentid=#{studentId} and projectid=#{projectId}")
    ProjectScore findScore(ProjectScore projectScore);

    @Insert("insert into transcripts(matchid, projectid, studentid, grades, description, matchtime, date) values " +
            "(#{matchId},#{projectId},#{studentId},#{grades},#{description},#{matchTime},now())")
    void addScore(ProjectScore projectScore);

    @Delete("delete from transcripts where id=#{id}")
    void deleteScore(Integer id);

    @Update("update transcripts set grades=#{grades},description=#{description},matchtime=#{matchTime} where id=#{id}")
    void updateScore(ProjectScore projectScore);

    @Select("select * from transcripts where matchid=#{matchId}")
    List<ProjectScore> getScoreListByMatchId(String matchId);

    @Select("select * from transcripts where matchid=#{matchId} and projectid=#{projectId}")
    List<ProjectScore> getScoreListByMatchIdAndProjectId(String matchId, String projectId);

    @Select("select * from transcripts where studentid=#{studentId}")
    List<ProjectScore> getScoreListByStudentId(String studentId);

    @Select("select * from transcripts where matchid=#{matchId} and studentid=#{studentId}")
    List<ProjectScore> getScoreListByStudentIdAndMatchId(String matchId, String studentId);

    @Select("select * from transcripts where matchid=#{matchId} and studentid=#{studentId} and projectid=#{projectId}")
    List<ProjectScore> getScoreListByStudentIdAndMatchIdAndProjectId(String matchId, String studentId, String projectId);
}
