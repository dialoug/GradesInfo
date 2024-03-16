package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.User;

public interface UserService {
    User findByUsername(String username);
    void register(String username, String password,String typeId,int type);
    boolean findTeacherByUsername(String username);

    void updatePwd(String newPassword);
}
