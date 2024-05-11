package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.ProjectScore;

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
}
