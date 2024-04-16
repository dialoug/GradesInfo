package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher (teacherid, date) VALUES (#{teacherId},now())")
    void addTeacher(String teacherId);

    @Delete("delete from teacher where teacherid=#{teacherId}")
    void deleteTeacher(String teacherId);

    @Update("update teacher set teachername=#{TeacherName},Gender=#{Gender},phonenumber=#{PhoneNumber} where teacherid=#{teacherId}")
    void updateTeacher(Teacher teacher);

    @Update("update teacher_academy set academyid=#{academyId} where teacherid=#{teacherId}")
    void updateTeacherAcademyId(String teacherId, String academyId);

    @Select("select * from teacher where teacherid=#{teacherId}")
    Teacher findTeacherByTeacherId(String teacherId);

    @Select("select typeid from user_type where username=#{username} and type=2")
    String findTeacherIdByUsername(String username);

    @Select("select *from teacher")
    List<Teacher> getAllTeacher();

    @Select("select * from teacher where teacherid=" +
            "(select * from teacher_academy where academyid =#{academyId})")
    List<Teacher> getTeacherByAcademy(Integer academyId);


}
