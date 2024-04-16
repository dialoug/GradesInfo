package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.User;

import java.util.List;

public interface UserService {

    void register(String username, String password, String typeId, int type);


    void updatePwd(String newPassword);

    User findByUsername(String username);

    boolean findTeacherByUsername(String username);

    List<User> getUserList();
}
