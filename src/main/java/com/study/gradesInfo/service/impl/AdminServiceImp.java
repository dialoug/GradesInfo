package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.mapper.AdminMapper;
import com.study.gradesInfo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void addTeacher(String teacherId) {
        adminMapper.addTeacherId(teacherId);
    }

    @Override
    public Admin findAdminByUsername(String username) {
        return adminMapper.findAdminByAdminId(adminMapper.findWorkIdByUsername(username));
    }
}
