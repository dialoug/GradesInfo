package com.study.gradesInfo.entity;

import lombok.Data;

@Data
public class StudentGrade {
    String matchId;
    String projectId;
    String matchName;
    String projectName;
    int ranking;
    String grade;
    String description;
}
