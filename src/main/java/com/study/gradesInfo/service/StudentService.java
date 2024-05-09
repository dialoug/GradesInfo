package com.study.gradesInfo.service;

import com.study.gradesInfo.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void addStudentTeacher(String studentId);

    void addStudentClass(String studentId, String classId);

    void deleteStudent(String studentId);


    void updateTeacher(String studentId, String teacherId);

    void updateClass(String studentId, String classId);

    Student findStudentByStudentId(String studentId);

    List<Student> getStudentListByClassId(String classId);

    List<Student> findStudentByTeacherId();


    List<Student> getStudentList();


}
