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
    @PostMapping("/addAcademy")
    public Result addAcademy(@RequestBody @Validated Academy academy) {
        departmentService.addAcademy(academy);
        return Result.success(academy);
    }

    //教师权限
    @PostMapping("/addClass")
    public Result addClass(@RequestBody @Validated Class clas, String academyId) {
        if (departmentService.getClassById(clas.getClassId()) == null) {
            departmentService.addClass(clas);
            departmentService.addClassAcademy(clas.getClassId(), academyId);
        } else
            Result.error("该班级已存在！");
        return Result.success(clas);
    }

    //管理员权限
    @PostMapping("/deleteAcademy")
    public Result deleteAcademy(String academyId) {
        departmentService.deleteAcademy(academyId);
        return Result.success();
    }

    //教师权限
    @PostMapping("/deleteClass")
    public Result deleteClass(String classId) {
        departmentService.deleteClass(classId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/editAcademy")
    public Result<Academy> academyEdit(@RequestBody @Validated(Academy.update.class) Academy academy) {
        departmentService.updateAcademy(academy);
        return Result.success();
    }

    //教师权限
    @PutMapping("/editClass")
    public Result<Class> classEdit(@RequestBody @Validated(Class.update.class) Class clas) {
        departmentService.updateClass(clas);
        return Result.success();
    }

    //教师权限
    @PutMapping("/editClassAcademyId")
    public Result<Class> classAcademyIdEdit(String classId, String academyId) {
        departmentService.updateClassAcademyId(classId, academyId);
        return Result.success();
    }

    @GetMapping("/listAcademy")
    public Result<List<Academy>> academyList() {
        List<Academy> la = departmentService.getAcademyList();
        return Result.success(la);
    }

    @GetMapping("/listClass")
    public Result<List<Class>> classList(String academyId) {
        List<Class> lc = departmentService.getClassListByAcademyId(academyId);
        return Result.success(lc);
    }

    @GetMapping("/infoAcademy")
    public Result<Academy> academyInfo(String academyId) {
        return Result.success(departmentService.getAcademyById(academyId));
    }

    @GetMapping("/infoClass")
    public Result<Class> classInfo(String classId) {
        return Result.success(departmentService.getClassById(classId));
    }


}