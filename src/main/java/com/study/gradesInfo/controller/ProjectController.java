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
    public Result deleteProject(@RequestBody String projectId) {
        System.out.println(projectId + "删除项目");
        projectService.deleteProject(projectId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/edit")
    public Result<Project> projectEdit(@RequestBody @Validated(Project.update.class) Project project) {
        System.out.println(project + "修改项目");
        projectService.updateProject(project);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Project>> projectList() {
        List<Project> projects = projectService.getProjectList();
        return Result.success((projects));
    }

    @GetMapping("/haveMatch")
    public Result<String> getMatchForProject(@RequestParam String matchId, @RequestParam String projectId) {
        String MatchId = projectService.getMatchByProject(matchId, projectId);
        return Result.success((MatchId));
    }


    @GetMapping("/getListByMatchId")
    public Result<List<Project>> getListByMatchId(@RequestParam String matchId) {
        List<Project> projects = projectService.getProjectByMatchId(matchId);
        System.out.println("获取项目通过比赛Id" + projects);
        return Result.success((projects));
    }

    @GetMapping("/getProject")
    public Result<Project> projectInfo(@RequestParam String projectId) {
        return Result.success(projectService.getProjectById(projectId));
    }

}
