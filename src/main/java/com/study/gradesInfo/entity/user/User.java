package com.study.gradesInfo.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    private Integer id;
    @NotNull
    private String userName;
    @JsonIgnore
    private String password;
    private Integer userType;

}
