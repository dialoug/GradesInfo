package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import static java.time.LocalTime.now;

@Mapper
public interface AdminMapper {
    @Insert("insert into teacher (teacherid,date)" + "values (#{teacherId}},now())")
    void addTeacherId(String teacherId);

    @Select("select * from admin where workid=#{workId}")
    Admin findAdminByAdminId(String workId);


    String findWorkIdByUsername(String username);

    @Insert("insert into admin(workid, name, phonenumber, date) VALUES (#{WorkId},#{Name},#{PhoneNumber},now())")
    void addAdmin(Admin admin);

    @Update("update admin set name=#{Name},phonenumber=#{PhoneNumber},date=now() where workid=#{WorkId}")
    void update(Admin admin);
}
