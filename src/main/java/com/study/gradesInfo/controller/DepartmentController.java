package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    //管理员权限
    //增加学院
    @PostMapping("/addAcademy")
    public Result addAcademy(@RequestBody @Validated Academy academy) {

        if (departmentService.getAcademyById(academy.getAcademyId()) == null) {
            departmentService.addAcademy(academy);
        } else
            return Result.error("该学院已存在！");

        return Result.success(academy);
    }

    //教师权限
    @PostMapping("/addClass")
    public Result addClass(@RequestBody @Validated Class clas, @RequestParam String academyId) {
        if (departmentService.getClassById(clas.getClassId()) == null) {
            departmentService.addClass(clas);
            departmentService.addClassAcademy(clas.getClassId(), academyId);
        } else
            return Result.error("该班级已存在！");
        return Result.success(clas);
    }

    //管理员权限
    @PostMapping("/deleteAcademy")
    public Result deleteAcademy(@RequestBody String academyId) {
        System.out.println(academyId);
        departmentService.deleteAcademy(academyId);
        return Result.success();
    }

    //教师权限
    @PostMapping("/deleteClass")
    public Result deleteClass(@RequestBody String classId) {
        System.out.println(classId);
        departmentService.deleteClass(classId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/editAcademy")
    public Result<Academy> academyEdit(@RequestBody @Validated(Academy.update.class) Academy academy) {
        System.out.println(academy.getAcademyId());
        departmentService.updateAcademy(academy);
        return Result.success();
    }

    //教师权限
    @PutMapping("/editClass")
    public Result<Class> classEdit(@RequestBody @Validated(Class.update.class) Class clas, @RequestParam String academyId) {
        System.out.println(academyId + "edit");
        departmentService.updateClass(clas, academyId);
        return Result.success();
    }

    @GetMapping("/listAcademy")
    public Result<List<Academy>> academyList() {
        List<Academy> la = departmentService.getAcademyList();
        return Result.success(la);
    }

    @GetMapping("/listClassNoAcademy")
    public Result<List<Class>> ClassNoAcademyList() {
        System.out.println("无学院班级");
        List<Class> lc = departmentService.getNoAcademyClass();
        return Result.success(lc);
    }

    @PostMapping("/listClassByAcademyId")
    public Result<List<Class>> classListByAcademyId(@RequestBody String academyId) {
        System.out.println(academyId);
        List<Class> lc = departmentService.getClassListByAcademyId(academyId);
        System.out.println(lc);
        return Result.success(lc);
    }

    @GetMapping("/listClass")
    public Result<List<Class>> classList() {
        List<Class> lc = departmentService.getClassList();
        return Result.success(lc);
    }

    //班级学院
    @GetMapping("/academyByClassId")
    public Result<Academy> AcademyByClassId(@RequestParam String classId) {
        Academy ra = departmentService.getAcademyByClassId(classId);

        System.out.println(classId + "当前班级找学院" + ra);
        return Result.success(ra);
    }

    @GetMapping("/academyByTeacherId")
    public Result<Academy> AcademyByTeacherId(@RequestParam String teacherId) {
        System.out.println(teacherId + "教师学院TeacherId");
        Academy la = departmentService.getAcademyByTeacherId(teacherId);
        System.out.println(la + "教师学院");
        return Result.success(la);
    }

    @GetMapping("/classByStudentId")
    public Result<Class> ClassByStudentId(@RequestParam String studentId) {
        System.out.println(studentId + "学生班级studentId");
        Class la = departmentService.getClassByStudentId(studentId);
        System.out.println(la + "教师学院");
        return Result.success(la);
    }
}