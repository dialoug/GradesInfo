package com.study.gradesInfo.entity.department;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class Academy {
    @NotNull(groups = {update.class, delete.class})
    private int id;
    @NotNull
    private Long AcademyId;
    @NotEmpty
    private String Name;
    private Integer ClassNumber;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }

}
