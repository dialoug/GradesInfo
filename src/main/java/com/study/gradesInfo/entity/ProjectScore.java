package com.study.gradesInfo.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class ProjectScore {
    @NotNull(groups = {ProjectScore.update.class, ProjectScore.delete.class})
    Integer id;
    String matchId;
    String projectId;
    String studentId;
    Integer grades;
    String description;
    String matchTime;

    public interface update extends Default {
    }

    public interface delete extends Default {
    }

}
