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
    public Student findStudentByStudentName(String studentName) {
        return studentMapper.findStudentById(studentMapper.findStudentIdByStudentName(studentName));
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);

    }

    @Override
    public List<Student> getStudentListByStudentId() {
        Map<String,Object>map=ThreadLocalUtil.get();
        String username=(String) map.get("username");
        //List<String>studentIdList=studentMapper.findStudentIdByTeacherId(teacherMapper.findTeacherIdByUsername(username));
        studentMapper.findStudentByUsername(username);

        return null;
    }

    @Override
    public List<Student> getStudentListByClassId(Long classId) {
       return studentMapper.getStudentByClassId(classId);
    }
}
