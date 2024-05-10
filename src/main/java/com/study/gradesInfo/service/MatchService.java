package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.Match;

import java.util.List;

public interface MatchService {


    List<Match> getMatchList();

    Match getMatchById(String matchId);

    void addMatch(Match match);

    void deleteMatch(String matchId);

    void updateMatch(Match match);

    String getMatchProject(String matchId, String projectId);

    void addMatchProject(String matchId, String projectId);

    void deleteMatchProject(String matchId, String projectId);
}
