package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {
        @Select("select * from teacher where teacherid=#{teacherId}")
        Teacher findTeacherByTeacherId(String teacherId);
        @Select("select typeid from user_type where username=#{username} and type=2")
        String findTeacherIdByUsername(String username);

}
