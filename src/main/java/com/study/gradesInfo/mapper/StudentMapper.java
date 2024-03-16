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

    @Select("select typeid from user_type where username=#{username} and type=1")
    String findStudentIdByStudentName(String username);

    @Insert("insert into student(studentid, studentname, classid, gender, age, date) VALUES (#{StudentId},#{StudentName},#{Gender},#{Age},#{ClassId},now())")
    void addStudent(Student student);

    @Select("select * from student where studentid=" +
            "(select studentid from student_teacher where teacherid=" +
            "(select typeid from user_type where username=#{username} and type=1))")
    void findStudentByUsername(String username);
    @Select("select * from student where classid=#{classId}")
    List<Student> getStudentByClassId(Long classId);
}
