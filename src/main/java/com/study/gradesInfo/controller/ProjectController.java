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

    //管理员权限
    @PostMapping("add")
    public Result addProject(@RequestBody @Validated Project project) {
        if (projectService.getProjectById(project.getProjectId()) == null) {
            projectService.addProject(project);
        } else
            return Result.error("该项目已存在！");
        return Result.success();
    }

    //管理员权限
    @PostMapping("/delete")
    public Result deleteProject(String projectId) {
        projectService.deleteProject(projectId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/edit")
    public Result<Project> projectEdit(@RequestBody @Validated(Project.update.class) Project project) {
        projectService.updateProject(project);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Project>> projectList() {
        List<Project> projects = projectService.getProjectList();
        return Result.success((projects));
    }

    @GetMapping("/info")
    public Result<Project> projectInfo(String projectId) {
        return Result.success(projectService.getProjectById(projectId));
    }

}
