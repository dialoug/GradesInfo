package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher (teacherid, date) VALUES (#{teacherId},now())")
    void addTeacher(String teacherId);

    @Insert("insert into teacher_academy (teacherid, academyid) values (#{teacherId},#{academyId})")
    void addTeacherAcademy(String teacherId, String academyId);

    @Delete("delete from teacher where teacherid=#{teacherId}")
    void deleteTeacher(String teacherId);

    @Update("update teacher set teachername=#{teacherName},Gender=#{gender},phonenumber=#{phoneNumber} " +
            "where teacherid=#{teacherId}")
    void updateTeacher(Teacher teacher);

    @Update("update teacher_academy set academyid=#{academyId} where teacherid=#{teacherId}")
    void updateTeacherAcademyId(String teacherId, String academyId);

    @Select("select * from teacher where teacherid=#{teacherId}")
    Teacher findTeacherByTeacherId(String teacherId);

    @Select("select typeid from user_type where username=#{username} and type=1")
    String findTeacherIdByUsername(String username);

    @Select("select *from teacher")
    List<Teacher> getAllTeacher();

    @Select("select * from teacher where teacherid in " +
            "(select teacherid from teacher_academy where academyid =#{academyId})")
    List<Teacher> getTeacherByAcademy(String academyId);

    @Select("select * from teacher where teacherid in " +
            "(select teacherid from teacher_academy where academyid is null)")
    List<Teacher> getTeacherNoAcademy();

    @Delete("delete from teacher_academy where teacherid=#{teacherId}")
    void deleteTeacher_Academy(String teacherId);

    @Select("select * from teacher where teacherid=" +
            "(select teacherid from student_teacher where studentid=#{studentId})")
    Teacher getTeacherByStudentId(String studentId);
}
