package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;
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

    @GetMapping
    public Result<List<Project>> projectList() {
        List<Project> projects = projectService.getProjectList();
        return Result.success((projects));
    }

    @PostMapping("addProject")
    public Result addProject(@RequestBody @Validated Project project) {
        projectService.addProject(project);
        return Result.success();
    }

    @PutMapping("/projecteidt")
    public Result<Project> projectEdit(@RequestBody @Validated(Project.update.class) Project project) {
        projectService.updateProject(project);
        return Result.success();
    }

    @GetMapping("/projectinfo")
    public Result<Project> projectInfo(String projectId) {
        return Result.success(projectService.getProjectById(projectId));
    }

}
