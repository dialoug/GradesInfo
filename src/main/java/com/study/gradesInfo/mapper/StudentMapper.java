package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into student(studentid, studentname, classid, gender, age, date) VALUES (#{StudentId},#{StudentName},#{Gender},#{Age},#{ClassId},now())")
    void addStudent(Student student);

    @Insert("insert into student_teacher(studentid, teacherid) VALUES (#{studentId},(" +
            "select typeid from user_type where username=#{username} and type=1))")
    void addStudentTeacher(String username, String studentId);

    @Delete("delete from student where studentid=#{studentId}")
    void deleteStudent(String studentId);

    @Update("update student set studentname=#{StudentName},classid=#{ClassId},gender=#{Gender},age=#{Age},date=now()")
    void updateStudent(Student student);

    @Select("select * from student")
    List<Student> getStudentAll();

    @Select("select * from student where studentid=#{id}")
    Student findStudentById(String id);

    @Select("select * from student where classid=#{classId}")
    List<Student> getStudentByClassId(Long classId);

    @Select("select * from student where studentid=" +
            "(select * from student_teacher where teacherid=" +
            "(select typeid from user_type where username=#{username} and type=1))")
    List<Student> getStudentByTeacherId(String username);

}
