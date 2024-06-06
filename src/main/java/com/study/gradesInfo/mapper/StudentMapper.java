package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into student(studentid, studentname, gender, age, date) VALUES " +
            "(#{studentId},#{studentName},#{gender},#{age},now())")
    void addStudent(Student student);

    @Insert("insert into student_teacher(studentid, teacherid) VALUES (#{studentId},(#{addId}))")
    void addStudentTeacher(String addId, String studentId);

    @Insert("insert into student_class(studentid, classid) VALUES (#{studentId},#{classId})")
    void addStudentClass(String studentId, String classId);

    @Delete("delete from student where studentid=#{studentId}")
    void deleteStudent(String studentId);

    @Update("update student_teacher set teacherid=#{teacherId} where studentid=#{studentId}")
    void updateTeacher(String studentId, String teacherId);

    @Update("update student_class set classid=#{classId} where studentid=#{studentId}")
    void updateClass(String studentId, String classId);

    @Select("select * from student")
    List<Student> getStudentAll();

    @Select("select * from student where studentid=#{id}")
    Student findStudentById(String id);

    @Select("select * from student where studentid in " +
            "(select studentid from student_class where classid=#{classId})")
    List<Student> getStudentByClassId(String classId);

    @Select("select * from student where studentid=" +
            "(select studentid from student_teacher where teacherid=" +
            "(select typeid from user_type where username=#{username} and type=1))")
    List<Student> getStudentByTeacherId(String username);

    @Delete("delete from student_teacher where studentid=#{studentId}")
    void deleteStudentTeacher(String studentId);

    @Update("UPDATE class SET studentnumber=(SELECT COUNT(*) AS studentnumber FROM student_class where classId=#{classId}) WHERE classId=#{classId};")
    void updateStudentNumber(String classId);

    @Update("UPDATE class SET studentnumber=studentnumber-1 WHERE classid=#{classId};")
    void decStudentNumber(String classId);

    @Select("select * from student_class where studentid=#{stucentId}")
    String getClassByStudentId(String studentId);

    @Delete("delete from student_class where studentid=#{studentId}")
    void deleteStudentClass(String studentId);
}
