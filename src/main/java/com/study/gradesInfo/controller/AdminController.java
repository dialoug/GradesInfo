package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.service.AdminService;
import com.study.gradesInfo.service.TeacherService;
import com.study.gradesInfo.utils.JwtUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/admininfo")
    public Result<Admin> adminInfo(@RequestHeader(name = "Authorization") String token){
        Map<String,Object> user= JwtUtil.parseToken(token);
        String username=(String) user.get("username");
        Admin admin=adminService.findAdminByUsername(username);
        return Result.success(admin);
    }
        @PostMapping("/addteacher")
    public Result addTeacher(@Pattern(regexp = "^[0-9]{5,20}$") String teacherId){
        Teacher teacher=teacherService.findTeacherByTeacherId(teacherId);
        if (teacher==null){
            adminService.addTeacher(teacherId);
            return Result.success();
        }else {
            return Result.error("该教师ID已占用！");
        }


    }


}
