package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import static java.time.LocalTime.now;

@Mapper
public interface AdminMapper {
    @Insert("insert into teacher (teacherid,date)"+"values (#{teacherId}},now())")
    void addTeacherId(String teacherId);

    @Select("select * from admin where workid=#{workId}")
    Admin findAdminByAdminId(String workId);

    @Select("select typeid from user_type where username=#{username} and type=3")
    String findWorkIdByUsername(String username);
}
