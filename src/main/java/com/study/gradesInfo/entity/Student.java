package com.study.gradesInfo.entity;

import com.study.gradesInfo.entity.department.Class;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    @NotNull(groups = {Class.update.class, Class.delete.class})
    private String studentId;
    private String studentName;
    private String gender;
    private Integer age;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }

}
