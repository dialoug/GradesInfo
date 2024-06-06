package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.entity.user.User;

import java.util.List;

public interface AdminService {
    void addAdmin(Admin admin);

    void deleteAdmin(String workId);

    void updateAdmin(Admin admin);

    Admin findAdminByUsername(String username);

    List<Admin> getAdminList();

    Admin findAdminByWorkId(String workId);

    User findUserByWorkId(String workId);
}
