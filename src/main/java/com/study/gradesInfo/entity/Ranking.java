package com.study.gradesInfo.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Ranking {
    int ranking;
    String matchId;
    String projectId;
    String studentId;
    String studentName;
    String description;
    LocalDate date;
}
