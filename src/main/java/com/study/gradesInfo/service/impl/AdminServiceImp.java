package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.mapper.AdminMapper;
import com.study.gradesInfo.mapper.UserMapper;
import com.study.gradesInfo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public void addAdmin(Admin admin) {
        userMapper.addUser(admin.getWorkId(), admin.getWorkId(), 3);
        adminMapper.addAdmin(admin);
        userMapper.addUserType(admin.getWorkId(), admin.getWorkId(), 3);
    }

    @Override
    public void deleteAdmin(String workId) {
        userMapper.deleteUser();
        adminMapper.deleteAdmin(workId);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public Admin findAdminByUsername(String username) {
        return adminMapper.findAdminByAdminId(adminMapper.findWorkIdByUsername(username));
    }

    @Override
    public List<Admin> getAdminList() {
        return adminMapper.getAllAdmin();
    }

}
