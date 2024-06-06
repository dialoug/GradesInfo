package com.study.gradesInfo.entity;

import lombok.Data;

@Data
public class GradeInfo {
    String matchId;
    String projectId;
    String prizeName;
    int topRanking;
    int underRanking;
    int grade;
}
