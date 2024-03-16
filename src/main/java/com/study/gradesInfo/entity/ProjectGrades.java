package com.study.gradesInfo.entity;

import lombok.Data;
@Data
public class ProjectGrades extends Project{
    Long matchId;
    Integer grades;
    String date;


}
