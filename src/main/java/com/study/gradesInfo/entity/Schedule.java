package com.study.gradesInfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;


@Data
public class Schedule {
    String gamename;
    String matchId;
    String projectId;
    String team1;
    String team2;
    int team1score;
    int team2score;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
