package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.ProjectScore;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.ProjectScoreService;
import com.study.gradesInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/score")
public class ProjectScoreController {
    @Autowired
    private ProjectScoreService projectScoreService;
    @Autowired
    private StudentService studentService;

    //@Validated(Class.update.class)
    @PutMapping("/add")
    public Result addGrade(@RequestBody ProjectScore projectScore) {
        if (projectScoreService.findScore(projectScore) == null) {
            if (studentService.findStudentByStudentId(projectScore.getStudentId()) != null) {
                projectScoreService.addScore(projectScore);
                System.out.println(projectScore.getGrades() + "成绩");
                return Result.success();
            } else {
                return Result.error("学生不存在！");
            }
        } else return Result.error("该成绩单已存在！");
    }


    @PostMapping("/delete")
    public Result deleteScore(@RequestParam int id) {
        projectScoreService.deleteScore(id);
        return Result.success();
    }

    //
//    //教师权限
    @PutMapping("/update")
    public Result updateScore(@RequestBody ProjectScore projectScore) {
        projectScoreService.updateScore(projectScore);
        System.out.println(projectScore + "更新成绩");
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<ProjectScore>> gradesList() {
        List<ProjectScore> lg = projectScoreService.getScoreList();
        System.out.println(lg + "成绩单");
        return Result.success(lg);
    }

    @GetMapping("/search")
    public Result<List<ProjectScore>> searchGrades(@RequestParam String matchId, @RequestParam String projectId, @RequestParam String studentId) {
        List<ProjectScore> lg;
        if (Objects.equals(studentId, "")) {
            if (Objects.equals(projectId, "")) {
                System.out.println("学生是空，项目是空");
                lg = projectScoreService.getScoreListByMatchId(matchId);
            } else
                lg = projectScoreService.getScoreListByMatchIdAndProjectId(matchId, projectId);
        } else if (Objects.equals(matchId, ""))
            lg = projectScoreService.getScoreListByStudentId(studentId);
        else if (Objects.equals(projectId, ""))
            lg = projectScoreService.getScoreListByStudentIdAndMatchId(matchId, studentId);
        else
            lg = projectScoreService.getScoreListByStudentIdAndMatchIdAndProjectId(matchId, studentId, projectId);
        System.out.println(lg + "成绩单" + matchId + studentId + projectId);
        return Result.success(lg);
    }


}
