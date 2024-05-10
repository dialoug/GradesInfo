package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //教师权限
    @PutMapping("/add")
    public Result addStudent(@RequestBody Student student, @RequestParam String classId) {
        if (studentService.findStudentByStudentId(student.getStudentId()) == null) {
            studentService.addStudent(student);
            studentService.addStudentTeacher(student.getStudentId());
            studentService.addStudentClass(student.getStudentId(), classId);
            return Result.success("学生添加成功（后台）");
        } else return Result.error("该学生已存在！");
    }

    //教师权限
    @PostMapping("/delete")
    public Result deleteStudent(@RequestBody String studentId) {
        studentService.deleteStudent(studentId);
        //System.out.println(studentId);
        return Result.success();
    }


    //教师权限
    @PutMapping("/teacher")
    public Result updateTeacher(String studentId, String teacherId) {
        studentService.updateTeacher(studentId, teacherId);
        return Result.success();
    }

    //教师权限
    @PutMapping("/editClass")
    public Result updateClass(@RequestParam String studentId, @RequestParam String classId) {
        System.out.println(studentId + "修改学生班级" + classId);
        studentService.updateClass(studentId, classId);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Student>> studentList() {
        List<Student> ls = studentService.getStudentList();
        System.out.println(ls);
        return Result.success(ls);
    }

    @GetMapping("/listByClass")
    public Result<List<Student>> studentListByClass(@RequestParam String classId) {
        List<Student> ls = studentService.getStudentListByClassId(classId);
        return Result.success(ls);
    }

    @GetMapping("/getStudentById")
    public Result<List<Student>> studentByStudentId(@RequestParam String studentId) {
        Student s = studentService.findStudentByStudentId(studentId);
        List<Student> ls = new ArrayList<>();
        ls.add(s);
        System.out.println(ls + "查找" + studentId);
        return Result.success(ls);
    }

    @GetMapping("/getStudent")
    public Result<List<Student>> getStudentList() {
        List<Student> ls = studentService.findStudentByTeacherId();
        return Result.success(ls);
    }

}
