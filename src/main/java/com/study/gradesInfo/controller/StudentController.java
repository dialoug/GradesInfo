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

    @GetMapping
    public Result<List<Student>> studentListByClass(Long classId) {
        List<Student> ls = studentService.getStudentListByClassId(classId);
        return Result.success(ls);
    }


}
