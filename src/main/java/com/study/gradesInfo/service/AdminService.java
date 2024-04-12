package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Admin;

public interface AdminService {

    Admin findAdminByUsername(String username);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);
}
