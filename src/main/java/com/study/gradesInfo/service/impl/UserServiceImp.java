package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.entity.user.User;
import com.study.gradesInfo.mapper.TeacherMapper;
import com.study.gradesInfo.mapper.UserMapper;
import com.study.gradesInfo.service.UserService;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void register(String username, String password, String typeId, int type) {
        //加密
        userMapper.addUser(username, password, type);
        userMapper.addUserType(username, typeId, type);
    }

    @Override
    public void updatePwd(String newPassword) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        userMapper.updatePwd(newPassword, username);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getAllUser();
    }

    @Override
    public User findByUsername(String username) {
        User u = userMapper.findByUsername(username);
        return u;
    }


    @Override
    public boolean findTeacherByUsername(String id) {
        Teacher teacher = teacherMapper.findTeacherByTeacherId(id);
        if (teacher != null) return true;
        else return false;
    }

}
