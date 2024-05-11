package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.ProjectScore;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.mapper.ProjectScoreMapper;
import com.study.gradesInfo.service.ProjectScoreService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<ProjectScore> getScoreList() {
        return projectScoreMapper.getAllScore();
    }

    @Override
    public ProjectScore findScore(ProjectScore projectScore) {
        return projectScoreMapper.findScore(projectScore);
    }

}
