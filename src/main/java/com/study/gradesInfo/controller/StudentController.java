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


    //教师权限
    @PutMapping("/add")
    public Result addStudent(@RequestBody Student student) {
        if (studentService.findStudentByStudentId(student.getStudentId()) == null) {
            studentService.addStudent(student);
            studentService.addStudentTeacher(student.getStudentId());
            return Result.success();
        } else return Result.error("该学生已存在！");
    }

    //教师权限
    @PostMapping("/delete")
    public Result deleteStudent(String studentId) {
        studentService.deleteStudent(studentId);
        return Result.success();
    }

    //教师权限
    @PutMapping("/update")
    public Result updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Student>> studentList() {
        List<Student> ls = studentService.getStudentList();
        return Result.success(ls);
    }

    @PostMapping("/listByClass")
    public Result<List<Student>> studentListByClass(Long classId) {
        List<Student> ls = studentService.getStudentListByClassId(classId);
        return Result.success(ls);
    }

    @GetMapping("/getStudent")
    public Result<List<Student>> getStudentList() {
        List<Student> ls = studentService.findStudentByTeacherId();
        return Result.success(ls);
    }

}
