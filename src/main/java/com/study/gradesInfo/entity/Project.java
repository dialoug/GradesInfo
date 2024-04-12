package com.study.gradesInfo.entity;

import com.study.gradesInfo.entity.department.Class;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class Project {
    @NotNull(groups = {Class.update.class, Class.delete.class})
    private Long Id;
    @NotNull
    private Long ProjectId;
    @NotEmpty
    private String Name;
    private String Description;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }
}
