package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.Student;

import java.util.List;

public interface StudentService {
    Student findStudentByStudentName(String studentName);

    void addStudent(Student student);

    List<Student> getStudentListByStudentId();

    List<Student> getStudentListByClassId(Long classId);
}
