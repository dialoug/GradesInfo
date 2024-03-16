package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student where studentid=#{id}")
    Student findStudentById(String id);

    @Insert("insert into student(studentid, studentname, classid, gender, age, date) VALUES (#{StudentId},#{StudentName},#{Gender},#{Age},#{ClassId},now())")
    void addStudent(Student student);

    @Select("select * from student where classid=#{classId}")
    List<Student> getStudentByClassId(Long classId);

    @Select("select * from student where studentid=(" +
            "select * from student_teacher where teacherid=(" +
            "select typeid from user_type where username=#{username} and type=1))")
    List<Student> getStudentByTeacherId(String username);

    @Insert("insert into student_teacher(studentid, teacherid) VALUES (#{studentId},(" +
            "select typeid from user_type where username=#{username} and type=1))")
    void addStudentTeacher(String username,String studentId);
}
