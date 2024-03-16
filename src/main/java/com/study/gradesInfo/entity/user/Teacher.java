package com.study.gradesInfo.entity.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teacher {
    private Long TeacherId;
    private String TeacherName;
    private String Gender;
    private String PhoneNumber;
    private Integer AcademyId;


}
