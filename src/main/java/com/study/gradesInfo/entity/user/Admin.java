package com.study.gradesInfo.entity.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin {
    private Long WorkId;
    private String Name;
    private String PhoneNumber;
    private Integer DepartmentId;

}
