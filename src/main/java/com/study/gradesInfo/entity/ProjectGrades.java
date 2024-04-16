package com.study.gradesInfo.entity;

import com.study.gradesInfo.entity.department.Academy;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class ProjectGrades extends Project {
    @NotNull(groups = {ProjectGrades.update.class, ProjectGrades.delete.class})
    String matchId;
    Integer grades;
    String date;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }

}
