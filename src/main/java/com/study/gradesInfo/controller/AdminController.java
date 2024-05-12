package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.service.AdminService;
import com.study.gradesInfo.utils.JwtUtil;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PutMapping("/add")
    public Result addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result deleteAdmin(String workId) {
        adminService.deleteAdmin(workId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Admin>> AdminList() {
        List<Admin> admins = adminService.getAdminList();
        return Result.success((admins));
    }

    @GetMapping("/getAdminInfoByUserName")
    public Result<Admin> adminInfo() {
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        Admin admin = adminService.findAdminByUsername(username);
        return Result.success(admin);
    }
}
