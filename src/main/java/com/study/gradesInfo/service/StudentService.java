package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.Student;

import java.util.List;

public interface StudentService {
    Student findStudentByStudentId(String studentId);

    void addStudent(Student student);

    List<Student> getStudentListByClassId(Long classId);

    List<Student> findStudentByTeacherId();

    void addStudentTeacher(String studentId);

    void updateStudent(Student student);

    List<Student> getStudentList();
}
