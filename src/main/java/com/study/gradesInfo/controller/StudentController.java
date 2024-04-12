package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public Result<List<Student>> studentListByClass(Long classId) {
        List<Student> ls = studentService.getStudentListByClassId(classId);
        return Result.success(ls);
    }

    @GetMapping
    public Result<List<Student>> studentList() {
        List<Student> ls = studentService.getStudentList();
        return Result.success(ls);
    }

    @PutMapping("/updatestudent")
    public Result updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return Result.success();
    }

    @PutMapping("/addstudent")
    public Result addStudent(@RequestBody Student student) {
        if (studentService.findStudentByStudentId(student.getStudentId()) == null) {
            studentService.addStudent(student);
            studentService.addStudentTeacher(student.getStudentId());
            return Result.success();
        } else return Result.error("该学生已存在！");
    }

    @GetMapping("/getstudent")
    public Result<List<Student>> getStudentList() {
        List<Student> ls = studentService.findStudentByTeacherId();
        return Result.success(ls);
    }

}
