package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.mapper.StudentMapper;
import com.study.gradesInfo.mapper.TeacherMapper;
import com.study.gradesInfo.service.StudentService;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Student findStudentByStudentId(String studentId) {
        return studentMapper.findStudentById(studentId);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public List<Student> getStudentListByClassId(Long classId) {
        return studentMapper.getStudentByClassId(classId);
    }

    @Override
    public List<Student> findStudentByTeacherId() {
        Map<String,Object>map=ThreadLocalUtil.get();
        return studentMapper.getStudentByTeacherId((String)map.get("username"));
    }

    @Override
    public void addStudentTeacher(String studentId) {
        Map<String,Object>map=ThreadLocalUtil.get();
        studentMapper.addStudentTeacher((String)map.get("username"),studentId);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentAll();
    }
}
