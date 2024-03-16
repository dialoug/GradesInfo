package com.study.gradesInfo.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    private Integer Id;
    @NotNull
    private String UserName;
    @JsonIgnore
    private String Password;
    private Integer UserType;

}
