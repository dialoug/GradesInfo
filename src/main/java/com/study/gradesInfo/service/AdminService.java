package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Admin;

public interface AdminService {
    void addTeacher(String teacherId);

    Admin findAdminByUsername(String username);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);
}
