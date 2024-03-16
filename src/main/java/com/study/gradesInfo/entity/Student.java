package com.study.gradesInfo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private String StudentId;
    private String StudentName;
    private String Gender;
    private Integer Age;
    private Integer ClassId;

}
