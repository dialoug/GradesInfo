package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.user.Teacher;

public interface TeacherService {
    Teacher findTeacherByUsername(String username);


    Teacher findTeacherByTeacherId(String teacherId);

    void updateTeacher(Teacher teacher);
}
