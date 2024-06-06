package com.study.gradesInfo.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Match {

    private Long Id;
    @NotNull
    private String matchId;
    @NotEmpty
    private String name;
    private String description;
    private String date;

}
