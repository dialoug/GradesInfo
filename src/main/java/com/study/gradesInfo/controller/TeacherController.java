package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.service.TeacherService;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //管理员权限
    @PostMapping("/add")
    public Result addTeacher(@Pattern(regexp = "^[0-9]{5,20}$") String teacherId, String academyId) {
        if (teacherService.findTeacherByTeacherId(teacherId) == null) {
            teacherService.addTeacher(teacherId);
            teacherService.addTeacherAcademy(teacherId, academyId);
            return Result.success();
        } else {
            return Result.error("该教师ID已占用！");
        }
    }

    //管理员权限
    @PostMapping("/delete")
    public Result deleteTeacher(String teacherId) {
        teacherService.deleteTeacher(teacherId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/update")
    public Result updateTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/update")
    public Result updateTeacherAcademyId(String teacherId, String academyId) {
        teacherService.updateTeacherAcademyId(teacherId, academyId);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Teacher>> teacherList() {
        List<Teacher> lt = teacherService.getTeacherList();
        return Result.success(lt);
    }

    @PostMapping("/listByAcademy")
    public Result<List<Teacher>> teacherListByClass(Integer academyId) {
        List<Teacher> lt = teacherService.getTeacherByAcademy(academyId);
        return Result.success(lt);
    }

    @GetMapping("/info")
    public Result<Teacher> teacherInfo() {
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        Teacher teacher = teacherService.findTeacherByUsername(username);
        return Result.success(teacher);
    }

}
