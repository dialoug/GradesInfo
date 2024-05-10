package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.Match;
import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.mapper.MatchMapper;
import com.study.gradesInfo.mapper.ProjectMapper;
import com.study.gradesInfo.service.MatchService;
import com.study.gradesInfo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImp implements MatchService {
    @Autowired
    MatchMapper matchMapper;

    //返回所有赛事
    @Override
    public List<Match> getMatchList() {
        List<Match> matches = matchMapper.getMatchList();
        return matches;
    }

    @Override
    public Match getMatchById(String matchId) {
        return matchMapper.getMatchById(matchId);
    }

    @Override
    public void addMatch(Match match) {
        matchMapper.addMatch(match);
    }

    @Override
    public void deleteMatch(String matchId) {
        matchMapper.deleteMatch(matchId);
    }

    @Override
    public void updateMatch(Match match) {
        matchMapper.updateMatch(match);
    }

    @Override
    public String getMatchProject(String matchId, String projectId) {
        return matchMapper.getProjectIdByMatchId(matchId, projectId);
    }

    @Override
    public void addMatchProject(String matchId, String projectId) {
        matchMapper.addMatchProject(matchId, projectId);
    }

    @Override
    public void deleteMatchProject(String matchId, String projectId) {
        matchMapper.deleteMatchProject(matchId, projectId);
    }
}

