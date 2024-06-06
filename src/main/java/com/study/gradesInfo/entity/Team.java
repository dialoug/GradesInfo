package com.study.gradesInfo.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Team {
    String matchId;
    String projectId;
    String teamname;
    String studentId;
    String studentName;
    int ranking;
    LocalDate date;
}
