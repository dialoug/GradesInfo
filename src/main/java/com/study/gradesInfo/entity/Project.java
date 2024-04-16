package com.study.gradesInfo.entity;

import com.study.gradesInfo.entity.department.Academy;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class Project {
    @NotNull(groups = {Project.update.class, Project.delete.class})
    private Long Id;
    @NotNull
    private String projectId;
    @NotEmpty
    private String name;
    private String description;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }
}
