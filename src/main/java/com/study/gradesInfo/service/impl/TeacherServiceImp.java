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
    public void addTeacherAcademy(String teacherId, String academyId) {
        teacherMapper.addTeacherAcademy(teacherId, academyId);
    }

    @Override
    public void deleteTeacher(String teacherId) {
        teacherMapper.deleteTeacher(teacherId);
        teacherMapper.deleteTeacher_Academy(teacherId);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public void updateTeacherAcademyId(String teacherId, String academyId) {
        teacherMapper.updateTeacherAcademyId(teacherId, academyId);
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
    public List<Teacher> getTeacherByAcademy(String academyId) {
        return teacherMapper.getTeacherByAcademy(academyId);
    }

    @Override
    public List<Teacher> getTeacherNoAcademy() {
        return teacherMapper.getTeacherNoAcademy();
    }

    @Override
    public Teacher getTeacherByStudentId(String studentId) {
        return teacherMapper.getTeacherByStudentId(studentId);
    }


}
