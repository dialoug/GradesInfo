package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.service.StudentService;
import com.study.gradesInfo.service.TeacherService;
import com.study.gradesInfo.utils.JwtUtil;
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

    @PutMapping("/addstudent")
    public Result addStudent(@RequestBody Student student) {
        if (studentService.findStudentByStudentId(student.getStudentId())==null){
            studentService.addStudent(student);
            studentService.addStudentTeacher(student.getStudentId());
            return Result.success();
        }else return Result.error("该学生已存在！");
    }

    @GetMapping("/getstudent")
    public Result<List<Student>> getStudentList() {
        List<Student> ls = studentService.findStudentByTeacherId();
        return Result.success(ls);
    }

    @PutMapping("/updatestudent")
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }
    @PutMapping("/updateteacher")
    public Result updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return Result.success();
    }
}
