package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Match;
import com.study.gradesInfo.entity.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MatchMapper {

    @Select("select * from matchform")
    List<Match> getMatchList();

    @Select("select * from matchform where matchid=#{matchId}")
    Match getMatchById(String matchId);

    @Insert("insert into matchform(name, matchid, description, date) values (#{name},#{matchId},#{description},#{date})")
    void addMatch(Match match);

    @Delete("delete from matchform where matchid=#{matchId}")
    void deleteMatch(String matchId);

    @Update("update matchform set name=#{name},description=#{description},date=#{date} where matchid=#{matchId}")
    void updateMatch(Match match);

    @Select("select projectid from match_project where matchid=#{matchId} and projectid=#{projectId}")
    String getProjectIdByMatchId(String matchId, String projectId);

    @Insert("insert into match_project(matchid, projectid) VALUES (#{matchId},#{projectId})")
    void addMatchProject(String matchId, String projectId);

    @Delete("delete from match_project where projectid=#{projectId} and matchid=#{matchId}")
    void deleteMatchProject(String matchId, String projectId);
}

