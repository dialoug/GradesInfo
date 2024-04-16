package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Admin;

import java.util.List;

public interface AdminService {
    void addAdmin(Admin admin);

    void deleteAdmin(String workId);

    void updateAdmin(Admin admin);

    Admin findAdminByUsername(String username);

    List<Admin> getAdminList();
}
