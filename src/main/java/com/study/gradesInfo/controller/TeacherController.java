package com.study.gradesInfo.controller;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.service.TeacherService;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacherinfo")
    public Result<Teacher> teacherInfo() {
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        Teacher teacher = teacherService.findTeacherByUsername(username);
        return Result.success(teacher);
    }


    @PostMapping("/addteacher")
    public Result addTeacher(@Pattern(regexp = "^[0-9]{5,20}$") String teacherId) {
        Teacher teacher = teacherService.findTeacherByTeacherId(teacherId);
        if (teacher == null) {
            teacherService.addTeacher(teacherId);
            return Result.success();
        } else {
            return Result.error("该教师ID已占用！");
        }
    }

    @PostMapping("/deleteteacher")
    public Result deleteTeacher() {
        teacherService.deleteTeacher();
        return Result.success();
    }

    @PutMapping("/updateteacher")
    public Result updateTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return Result.success();
    }
}
