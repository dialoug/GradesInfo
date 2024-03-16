package com.study.gradesInfo.entity.department;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class Class {
    @NotNull(groups = {update.class, delete.class})
    private int Id;
    @NotNull
    private Long AcademyId;
    @NotNull
    private Long ClassId;
    @NotEmpty
    private String ClassName;
    private int StudentNumber;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }

}
