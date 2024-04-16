package com.study.gradesInfo.entity;

import com.study.gradesInfo.entity.department.Class;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class Project {
    private Long Id;
    @NotNull
    private Long projectId;
    @NotEmpty
    private String name;
    private String description;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }
}
