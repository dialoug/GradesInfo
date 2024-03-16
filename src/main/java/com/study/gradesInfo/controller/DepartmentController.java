package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Academy;
import com.study.gradesInfo.entity.Class;
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

    @PostMapping("/academy")
    public Result addAcademy(@RequestBody @Validated Academy academy) {
        departmentService.addAcademy(academy);
        return Result.success(academy);
    }

    @PostMapping("/class")
    public Result addClass(@RequestBody @Validated Class clas) {
        departmentService.addClass(clas);
        return Result.success(clas);
    }

    @GetMapping("/academy")
    public Result<List<Academy>> academyList() {
        List<Academy> la = departmentService.getAcademyList();
        return Result.success(la);
    }

    @GetMapping("/class")
    public Result<List<Class>> classList(String academyId) {
        List<Class> lc = departmentService.getClassListByAcademyId(academyId);
        return Result.success(lc);
    }

    @GetMapping("/academyinfo")
    public Result<Academy> academyInfo(String academyId) {
        return Result.success(departmentService.getAcademyById(academyId));
    }

    @GetMapping("/classinfo")
    public Result<Class> classInfo(String classId) {
        return Result.success(departmentService.getClassById(classId));
    }

    @PutMapping("/academyeidt")
    public Result<Academy> academyEdit(@RequestBody @Validated(Academy.update.class) Academy academy) {
        departmentService.updateAcademy(academy);
        return Result.success();
    }

    @PutMapping("/classedit")
    public Result<Class> classEdit(@RequestBody @Validated(Class.update.class)Class clas) {
        departmentService.updateClass(clas);
        return Result.success();
    }

}
