package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.*;
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

    @Insert("insert into team_student(matchid,projectid,teamname, studentid,studentname) VALUES (#{matchId},#{projectId},#{teamname},#{studentId},#{studentName})")
    void addTeamStudent(Team team);

    @Select("select * from team_student where teamname=#{teamname}")
    Team findTeamByTeamName(String teamname);

    @Delete("delete from team_student where matchid=#{matchId} and projectId=#{projectId} and teamname=#{teamname} and studentid=#{studentId}")
    void deleteTeam(Team team);

    @Select("select * from team_student where matchid=#{matchId} and projectid=#{projectId} and teamname=#{teamname} and studentid=#{studentId}")
    Team findTeam(Team team);

    @Select("select * from schedule where projectid=#{projectId} and matchid=#{matchId} and gamename=#{gamename}")
    Schedule findSchedule(Schedule schedule);

    @Insert("insert into schedule(matchid, projectid, gamename, team1, team2, team1score, team2score, date) VALUES (#{matchId},#{projectId},#{gamename},#{team1},#{team2},#{team1score},#{team2score},#{date})")
    void addSchedule(Schedule schedule);

    @Update("update schedule set team1=#{team1},team2=#{team2},team1score=#{team1score},team2score=#{team2score},date=#{date} where matchid=#{matchId} and projectId=#{projectId} and gamename=#{gamename}")
    void updateSchedule(Schedule schedule);

    @Delete("delete from schedule where matchid=#{matchId} and projectid=#{projectId} and gamename=#{gamename}")
    void deleteSchedule(Schedule schedule);

    @Select("select * from schedule where projectid=#{projectId} and matchid=#{matchId}")
    List<Schedule> getSchedule(String matchId, String projectId);

    @Select("select * from team_student where matchid=#{matchId} and projectid=#{projectId} and teamname=#{teamname}")
    List<Team> getTeamMember(String matchId, String projectId, String teamname);

    @Select("select * from ranking where matchid=#{matchId} and projectid=#{projectId} and (ranking=#{ranking} OR studentid = #{studentId})")
    Ranking findRanking(Ranking ranking);

    @Insert("insert into ranking(ranking, matchid, projectid, studentid, studentname, description, date) VALUES (#{ranking},#{matchId},#{projectId},#{studentId},#{studentName},#{description},#{date})")
    void addRanking(Ranking ranking);

    @Update("update ranking set studentid=#{studentId},studentname=#{studentName},description=#{description},date=#{date} where matchid=#{matchId} and projectid=#{projectId} and ranking=#{ranking}")
    void updateRankingRanking(Ranking ranking);

    @Delete("delete from ranking where matchid=#{matchId} and projectid=#{projectId} and ranking = #{ranking}")
    void deleteRanking(Ranking ranking);

    @Select("SELECT * from ranking where matchid=#{matchId} and projectid=#{projectId}")
    List<Ranking> getRanking(String matchId, String projectId);

    @Update("update ranking set ranking=#{ranking},studentname=#{studentName},description=#{description},date=#{date} where matchid=#{matchId} and projectid=#{projectId} and studentid=#{studentId}")
    void updateRankingStudentId(Ranking ranking);

    @Select("select * from team_schedule where matchid=#{matchId} and projectid=#{projectId}")
    List<Team> getTeamList(String matchId, String projectId);

    @Update("update team_student set teamname=#{team1} where teamname=(select team1 from schedule where matchid=#{matchId} and projectId=#{projectId} and gamename=#{gamename})")
    void updateTeam1StudentBySchedule(Schedule schedule);

    @Update("update team_student set teamname=#{team2} where teamname=(select team2 from schedule where matchid=#{matchId} and projectId=#{projectId} and gamename=#{gamename})")
    void updateTeam2StudentBySchedule(Schedule schedule);

    @Insert("insert into team_schedule(matchid, projectid, gamename, teamname) VALUES (#{matchId},#{projectId},#{gamename},#{team1})")
    void addTeam1Schedule(Schedule schedule);

    @Insert("insert into team_schedule(matchid, projectid, gamename, teamname) VALUES (#{matchId},#{projectId},#{gamename},#{team2})")
    void addTeam2Schedule(Schedule schedule);

    @Update("update team_schedule set teamname=#{team1} where teamname=(select team1 from schedule where matchid=#{matchId} and projectId=#{projectId} and gamename=#{gamename})")
    void updateTeam1Schedule(Schedule schedule);

    @Update("update team_schedule set teamname=#{team2} where teamname=(select team2 from schedule where matchid=#{matchId} and projectId=#{projectId} and gamename=#{gamename})")
    void updateTeam2Schedule(Schedule schedule);

    @Select("select * from team_schedule where matchid=#{matchId} and projectid=#{projectId}")
    List<Team> getTeamRanking(String matchId, String projectId);

    @Update("update team_schedule set ranking=#{ranking},date=#{date} where matchid=#{matchId} and projectid=#{projectId} and teamname=#{teamname}")
    void updateTeamRanking(Team team);

    @Update("update team_schedule set ranking=null,date=null where matchid=#{matchId} and projectid=#{projectId} and teamname=#{teamname}")
    void deleteTeamRanking(Team team);

    @Select("select * from ranking where matchid=#{matchId}")
    List<Ranking> getProjectRanking(String matchId);

    @Select("select * from gradeinfo where matchid=#{matchId} and projectid=#{projectId} and topranking<=#{ranking} and underranking>=#{ranking}")
    GradeInfo getGradeInfo(String matchId, String projectId, String ranking);

    @Select("select * from team_schedule where matchid=#{matchId}")
    List<Team> getTeamProjectRanking(String matchId);

    @Select("select * from team_student where matchid=#{matchId} and projectid=#{projectId} and teamname=#{teamname}")
    List<Team> getStudentByTeamname(String matchId, String projectId, String teamname);

    @Select("select prizename from gradeinfo where matchid=#{matchId} and projectid=#{projectId} and topranking<=#{ranking} and underranking>=#{ranking}")
    String getPrizeName(String matchId, String projectId, int ranking);

    @Select("select * from ranking where studentid=#{studentId}")
    List<Ranking> getRankingByStudentId(String studentId);

    @Select("select * from team_student where studentid=#{studentId}")
    List<Team> getTeamByStudentId(String studentId);

    @Select("select ranking from team_schedule where teamname=#{teamname}")
    Integer getTeamRankingByTeamName(String teamname);

    @Select("select name from matchform where matchid=#{matchId}")
    String getMatchNameByMatchId(String matchId);

    @Select("select name from project where projectid=#{projectId}")
    String getProjectNameByProjectId(String projectId);
}
