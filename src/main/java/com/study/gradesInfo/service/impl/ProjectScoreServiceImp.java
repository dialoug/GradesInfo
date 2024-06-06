package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.ProjectScore;
import com.study.gradesInfo.entity.Ranking;
import com.study.gradesInfo.entity.Schedule;
import com.study.gradesInfo.entity.Team;
import com.study.gradesInfo.mapper.ProjectScoreMapper;
import com.study.gradesInfo.service.ProjectScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectScoreServiceImp implements ProjectScoreService {
    @Autowired
    ProjectScoreMapper projectScoreMapper;

    @Override
    public void addScore(ProjectScore projectScore) {
        projectScoreMapper.addScore(projectScore);
    }

    @Override
    public void deleteScore(Integer id) {
        projectScoreMapper.deleteScore(id);
    }

    @Override
    public void updateScore(ProjectScore projectScore) {
        projectScoreMapper.updateScore(projectScore);
    }

    @Override
    public List<ProjectScore> getScoreListByMatchId(String matchId) {
        return projectScoreMapper.getScoreListByMatchId(matchId);
    }

    @Override
    public List<ProjectScore> getScoreListByMatchIdAndProjectId(String matchId, String projectId) {
        return projectScoreMapper.getScoreListByMatchIdAndProjectId(matchId, projectId);
    }

    @Override
    public List<ProjectScore> getScoreListByStudentId(String studentId) {
        return projectScoreMapper.getScoreListByStudentId(studentId);
    }

    @Override
    public List<ProjectScore> getScoreListByStudentIdAndMatchId(String matchId, String studentId) {
        return projectScoreMapper.getScoreListByStudentIdAndMatchId(matchId, studentId);
    }

    @Override
    public List<ProjectScore> getScoreListByStudentIdAndMatchIdAndProjectId(String matchId, String studentId, String projectId) {
        return projectScoreMapper.getScoreListByStudentIdAndMatchIdAndProjectId(matchId, studentId, projectId);
    }

    @Override
    public void uploadTranscripts(String url) {

    }

    @Override
    public void addTeam(Team team) {
        projectScoreMapper.addTeamStudent(team);
    }

    @Override
    public Team findTeamByTeamName(String teamname) {
        return projectScoreMapper.findTeamByTeamName(teamname);
    }

    @Override
    public void deleteTeam(Team team) {
        projectScoreMapper.deleteTeam(team);
    }

    @Override
    public boolean findTeam(Team team) {
        if (projectScoreMapper.findTeam(team) != null)
            return true;
        return false;
    }

    @Override
    public boolean findSchedule(Schedule schedule) {
        if (projectScoreMapper.findSchedule(schedule) != null)
            return true;
        return false;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        projectScoreMapper.addTeam1Schedule(schedule);
        projectScoreMapper.addTeam2Schedule(schedule);
        projectScoreMapper.addSchedule(schedule);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        projectScoreMapper.updateTeam1StudentBySchedule(schedule);
        projectScoreMapper.updateTeam2StudentBySchedule(schedule);
        projectScoreMapper.updateTeam1Schedule(schedule);
        projectScoreMapper.updateTeam2Schedule(schedule);
        projectScoreMapper.updateSchedule(schedule);
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        projectScoreMapper.deleteSchedule(schedule);
    }

    @Override
    public List<Schedule> getSchedule(String matchId, String projectId) {
        return projectScoreMapper.getSchedule(matchId, projectId);
    }

    @Override
    public List<Team> getTeamMember(String matchId, String projectId, String teamname) {
        return projectScoreMapper.getTeamMember(matchId, projectId, teamname);
    }

    @Override
    public Ranking findRanking(Ranking ranking) {
        return projectScoreMapper.findRanking(ranking);
    }

    @Override
    public void addRanking(Ranking ranking) {
        projectScoreMapper.addRanking(ranking);
    }

    @Override
    public void updateRankingRanking(Ranking ranking) {
        projectScoreMapper.updateRankingRanking(ranking);
    }

    @Override
    public void deleteRanking(Ranking ranking) {
        projectScoreMapper.deleteRanking(ranking);
    }

    @Override
    public List<Ranking> getRanking(String matchId, String projectId) {
        return projectScoreMapper.getRanking(matchId, projectId);
    }

    @Override
    public void updateRankingStudentId(Ranking ranking) {
        projectScoreMapper.updateRankingStudentId(ranking);
    }

    @Override
    public List<Team> getTeamList(String matchId, String projectId) {
        return projectScoreMapper.getTeamList(matchId, projectId);
    }

    @Override
    public List<Team> getTeamRanking(String matchId, String projectId) {
        return projectScoreMapper.getTeamRanking(matchId, projectId);
    }

    @Override
    public void updateTeamRanking(Team team) {
        projectScoreMapper.updateTeamRanking(team);
    }

    @Override
    public void deleteTeamRanking(Team team) {
        projectScoreMapper.deleteTeamRanking(team);
    }


    @Override
    public List<ProjectScore> getScoreList() {
        return projectScoreMapper.getAllScore();
    }

    @Override
    public ProjectScore findScore(ProjectScore projectScore) {
        return projectScoreMapper.findScore(projectScore);
    }

}
