package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where teacherid=#{teacherId}")
    Teacher findTeacherByTeacherId(String teacherId);

    @Select("select typeid from user_type where username=#{username} and type=2")
    String findTeacherIdByUsername(String username);

    @Update("update teacher set teachername=#{TeacherName},Gender=#{Gender},phonenumber=#{PhoneNumber}")
    void updateTeacher(Teacher teacher);
}
