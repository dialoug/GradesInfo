package com.study.gradesInfo.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Project {

    private Long Id;
    @NotNull
    private Long ProjectId;
    @NotEmpty
    private String Name;
    private String Description;


}
