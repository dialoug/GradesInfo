package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.service.StudentService;
import com.study.gradesInfo.utils.FileUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


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

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + file.getOriginalFilename();
        System.out.println(fileName);
        file.transferTo(new File("E:\\DSSOUG\\maven\\GradesInfo\\ExcelData\\student\\" + fileName));
        return Result.success("E:\\DSSOUG\\maven\\GradesInfo\\ExcelData\\student\\" + fileName);
    }

    FileUtil fileUtil = new FileUtil();

    @PatchMapping("/updateStudentExcel")
    public Result<List<Result>> updateTranscripts(@RequestBody String url) {
        System.out.println(url);
        List<Result> results = new ArrayList<>();
        Sheet sheet = fileUtil.setFirstRow(url);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Student student = new Student();
            String classId = "";
            for (Cell cell : row) {
                switch (fileUtil.getColumnHeader(cell)) {
                    case "ID":
                        // 处理 ID 列
                        break;
                    case "学号":
                        student.setStudentId(fileUtil.getCellValue(cell));
                        break;
                    case "学生姓名":
                        student.setStudentName(fileUtil.getCellValue(cell));
                        break;
                    case "性别":
                        student.setGender(fileUtil.getCellValue(cell));
                        break;
                    case "年龄":
                        student.setAge(Integer.valueOf(fileUtil.getCellValue(cell)));
                        break;
                    case "班级Id":
                        classId = fileUtil.getCellValue(cell);
                        break;
                }
            }
            System.out.println(student);
            Result result = addStudent(student, classId);
            results.add(result);
            System.out.println(result.getMessage());
        }
        fileUtil.closeFile();
        return Result.success(results);
    }
}
