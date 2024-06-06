package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.ProjectScore;
import com.study.gradesInfo.entity.Ranking;
import com.study.gradesInfo.entity.Schedule;
import com.study.gradesInfo.entity.Team;

import java.util.List;

public interface ProjectScoreService {

    List<ProjectScore> getScoreList();

    ProjectScore findScore(ProjectScore projectScore);

    void addScore(ProjectScore projectScore);

    void deleteScore(Integer id);

    void updateScore(ProjectScore projectScore);

    List<ProjectScore> getScoreListByMatchId(String matchId);

    List<ProjectScore> getScoreListByMatchIdAndProjectId(String matchId, String projectId);

    List<ProjectScore> getScoreListByStudentId(String studentId);

    List<ProjectScore> getScoreListByStudentIdAndMatchId(String matchId, String studentId);

    List<ProjectScore> getScoreListByStudentIdAndMatchIdAndProjectId(String matchId, String studentId, String projectId);

    void uploadTranscripts(String url);

    void addTeam(Team team);

    Team findTeamByTeamName(String teamname);


    void deleteTeam(Team team);


    boolean findTeam(Team team);

    boolean findSchedule(Schedule schedule);

    void addSchedule(Schedule schedule);

    void updateSchedule(Schedule schedule);

    void deleteSchedule(Schedule schedule);

    List<Schedule> getSchedule(String matchId, String projectId);

    List<Team> getTeamMember(String matchId, String projectId, String teamname);

    Ranking findRanking(Ranking ranking);

    void addRanking(Ranking ranking);

    void updateRankingRanking(Ranking ranking);

    void deleteRanking(Ranking ranking);

    List<Ranking> getRanking(String matchId, String projectId);

    void updateRankingStudentId(Ranking ranking);

    List<Team> getTeamList(String matchId, String projectId);

    List<Team> getTeamRanking(String matchId, String projectId);

    void updateTeamRanking(Team team);

    void deleteTeamRanking(Team team);
}
