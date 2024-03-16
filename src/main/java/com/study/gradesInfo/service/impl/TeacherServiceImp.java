package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.mapper.TeacherMapper;
import com.study.gradesInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher findTeacherByUsername(String username) {
        return teacherMapper.findTeacherByTeacherId(teacherMapper.findTeacherIdByUsername(username));
    }

    @Override
    public Teacher findTeacherByTeacherId(String teacherId) {
        return teacherMapper.findTeacherByTeacherId(teacherId);
    }

}
