package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Teacher;

import java.util.List;

public interface TeacherService {

    void addTeacher(String teacherId);

    void addTeacherAcademy(String teacherId, String academyId);

    void deleteTeacher(String teacherId);

    void updateTeacher(Teacher teacher);

    void updateTeacherAcademyId(String teacherId, String academyId);

    Teacher findTeacherByUsername(String username);

    Teacher findTeacherByTeacherId(String teacherId);

    List<Teacher> getTeacherList();

    List<Teacher> getTeacherByAcademy(String academyId);


    List<Teacher> getTeacherNoAcademy();
}
