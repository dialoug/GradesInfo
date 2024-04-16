package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.mapper.TeacherMapper;
import com.study.gradesInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public void addTeacher(String teacherId) {
        teacherMapper.addTeacher(teacherId);
    }

    @Override
    public void deleteTeacher(String teacherId) {
        teacherMapper.deleteTeacher(teacherId);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        return teacherMapper.findTeacherByTeacherId(teacherMapper.findTeacherIdByUsername(username));
    }

    @Override
    public Teacher findTeacherByTeacherId(String teacherId) {
        return teacherMapper.findTeacherByTeacherId(teacherId);
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherMapper.getAllTeacher();
    }

    @Override
    public List<Teacher> getTeacherByAcademy(Integer academyId) {
        return teacherMapper.getTeacherByAcademy(academyId);
    }


}
