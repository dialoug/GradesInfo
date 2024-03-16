package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping
    public Result addProject(@RequestBody @Validated Project project){
        projectService.addProject(project);
        return Result.success();
    }

    @GetMapping
    public Result<List<Project>> projectList(){
        List<Project> projects=projectService.getProjectList();
        return Result.success((projects));
    }
}
