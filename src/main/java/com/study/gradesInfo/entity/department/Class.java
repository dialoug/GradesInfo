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
    private String classId;
    @NotEmpty
    private String name;
    private int studentNumber;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }

}
