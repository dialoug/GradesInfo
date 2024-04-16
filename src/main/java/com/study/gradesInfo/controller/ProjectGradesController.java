package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.ProjectGrades;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.ProjectGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class ProjectGradesController {
    @Autowired
    private ProjectGradesService projectGradesService;

    @PutMapping("/add")
    public Result addGrade(@RequestBody ProjectGrades projectGrades, String projectId) {
        if (projectGradesService.findGradeByGradeId(projectGrades.getProjectId()) == null) {
            projectGradesService.addGrade(projectGrades);
            projectGradesService.addGradeProject(projectGrades.getProjectId(), projectId);
            return Result.success();
        } else return Result.error("该成绩单已存在！");
    }

    //教师权限
    @PostMapping("/delete")
    public Result deleteGrade(String gradeId) {
        projectGradesService.deleteGrade(gradeId);
        return Result.success();
    }

    //教师权限
    @PutMapping("/update")
    public Result updateGrade(@RequestBody ProjectGrades projectGrades) {
        projectGradesService.updateGrade(projectGrades);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<ProjectGrades>> gradesList() {
        List<ProjectGrades> lg = projectGradesService.getGradesList();
        return Result.success(lg);
    }


}
