package com.study.gradesInfo.controller;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.service.AdminService;
import com.study.gradesInfo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admininfo")
    public Result<Admin> adminInfo(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> user = JwtUtil.parseToken(token);
        String username = (String) user.get("username");
        Admin admin = adminService.findAdminByUsername(username);
        return Result.success(admin);
    }


    @PutMapping("/addadmin")
    public Result addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return Result.success();
    }


}
