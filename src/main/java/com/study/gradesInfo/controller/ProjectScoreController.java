package com.study.gradesInfo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.gradesInfo.entity.ProjectScore;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.ProjectScoreService;
import com.study.gradesInfo.service.StudentService;
import com.study.gradesInfo.utils.FileUtil;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + file.getOriginalFilename();
        System.out.println(fileName);
        file.transferTo(new File("E:\\DSSOUG\\maven\\GradesInfo\\ExcelData\\transcripts\\" + fileName));
        return Result.success("E:\\DSSOUG\\maven\\GradesInfo\\ExcelData\\transcripts\\" + fileName);
    }

    FileUtil fileUtil = new FileUtil();

    @PatchMapping("/updateTranscriptsExcel")
    public Result<List<Result>> updateTranscripts(@RequestBody String url) {
        System.out.println(url);
        List<Result> results = new ArrayList<>();
        Sheet sheet = fileUtil.setFirstRow(url);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            ProjectScore projectScore = new ProjectScore();
            for (Cell cell : row) {
                switch (fileUtil.getColumnHeader(cell)) {
                    case "ID":
                        // 处理 ID 列
                        break;
                    case "赛事Id":
                        projectScore.setMatchId(fileUtil.getCellValue(cell));
                        break;
                    case "项目Id":
                        projectScore.setProjectId(fileUtil.getCellValue(cell));
                        break;
                    case "学号":
                        projectScore.setStudentId(fileUtil.getCellValue(cell));
                        break;
                    case "分数":
                        projectScore.setGrades(Integer.valueOf(fileUtil.getCellValue(cell)));
                        break;
                    case "班级Id":
                        projectScore.setDescription(fileUtil.getCellValue(cell));
                        break;
                    case "比赛时间":
                        projectScore.setMatchTime(fileUtil.getCellValue(cell));
                        break;
                    default:
                        break;
                }
            }
            System.out.println(projectScore);
            Result result = addGrade(projectScore);
            results.add(result);
            System.out.println(result.getMessage());
        }
        fileUtil.closeFile();
        return Result.success(results);
    }
}
