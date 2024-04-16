package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Teacher;

import java.util.List;

public interface TeacherService {

    void addTeacher(String teacherId);

    void deleteTeacher(String teacherId);

    void updateTeacher(Teacher teacher);

    Teacher findTeacherByUsername(String username);

    Teacher findTeacherByTeacherId(String teacherId);

    List<Teacher> getTeacherList();

    List<Teacher> getTeacherByAcademy(Integer academyId);
}
