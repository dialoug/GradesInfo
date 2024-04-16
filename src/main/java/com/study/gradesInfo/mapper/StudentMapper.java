package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into student(studentid, studentname, gender, age, date) VALUES (#{studentId},#{studentName},#{gender},#{age},now())")
    void addStudent(Student student);

    @Insert("insert into student_teacher(studentid, teacherid) VALUES (#{studentId},(" +
            "select typeid from user_type where username=#{username} and type=1))")
    void addStudentTeacher(String username, String studentId);

    @Insert("insert into student_class(studentid, classid) VALUES (#{studentId},#{classId})")
    void addStudentClass(String studentId, String classId);

    @Delete("delete from student where studentid=#{studentId}")
    void deleteStudent(String studentId);

    @Update("update student set studentname=#{studentName},gender=#{gender},age=#{age},date=now() where studentid=#{studentId}")
    void updateStudent(Student student);

    @Update("update student_teacher set teacherid=#{teacherId} where studentid=#{studentId}")
    void updateTeacher(String studentId, String teacherId);

    @Update("update student_class set classid=#{classId} where studentid=#{studentId}")
    void updateClass(String studentId, String classId);

    @Select("select * from student")
    List<Student> getStudentAll();

    @Select("select * from student where studentid=#{id}")
    Student findStudentById(String id);

    @Select("select * from student where studentid=" +
            "(select * from student_class where classid=#{classId})")
    List<Student> getStudentByClassId(Long classId);

    @Select("select * from student where studentid=" +
            "(select * from student_teacher where teacherid=" +
            "(select typeid from user_type where username=#{username} and type=1))")
    List<Student> getStudentByTeacherId(String username);

    @Insert("insert into student_project(studentid)values (${studentId})")
    void initializeStudentProject(String studentId);
}
