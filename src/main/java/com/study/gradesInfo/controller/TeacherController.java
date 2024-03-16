package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.service.StudentService;
import com.study.gradesInfo.service.TeacherService;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @GetMapping("/teacherinfo")
    public Result<Teacher> teacherInfo() {
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        Teacher teacher = teacherService.findTeacherByUsername(username);
        return Result.success(teacher);
    }

    @PostMapping("/addstudent")
    public Result addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return Result.success();
    }

    @GetMapping("/getstudent")
    public Result<List<Student>> getStudentList() {
        List<Student> ls = studentService.getStudentListByStudentId();
        return Result.success(ls);
    }


}
