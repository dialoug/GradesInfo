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
        System.out.println(admin);
        if (adminService.findAdminByWorkId(admin.getWorkId()) == null) {
            adminService.addAdmin(admin);
            return Result.success("管理员添加成功（后台）");
        } else return Result.error("该管理员已存在！");
    }

    @PostMapping("/delete")
    public Result deleteAdmin(@RequestParam String workId, @RequestParam String password) {
        System.out.println(workId + "," + password);
        if (adminService.findUserByWorkId(workId).getPassword().equals(password)) {
            adminService.deleteAdmin(workId);
        } else {
            return Result.error("密码错误");
        }
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

    @GetMapping("/getAdminInfoByWorkId")
    public Result<Admin> adminInfoId(@RequestParam String workId) {
        System.out.println(workId);
        Admin admin = adminService.findAdminByWorkId(workId);
        System.out.println(admin);
        return Result.success(admin);
    }
}
