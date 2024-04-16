package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static java.time.LocalTime.now;

@Mapper
public interface AdminMapper {
    @Insert("insert into admin(workid, name, phonenumber, date) VALUES (#{WorkId},#{Name},#{PhoneNumber},now())")
    void addAdmin(Admin admin);

    @Insert("insert into teacher (teacherid,date) values (#{teacherId},now())")
    void addTeacherId(String teacherId);

    @Delete("delete from admin where workid=#{workId}")
    void deleteAdmin(String workId);

    @Update("update admin set name=#{Name},phonenumber=#{PhoneNumber},date=now() where workid=#{WorkId}")
    void update(Admin admin);

    @Select("select workid from admin where name=#{username}")
    String findWorkIdByUsername(String username);


    @Select("select *from admin")
    List<Admin> getAllAdmin();

    @Select("select * from admin where workid=#{workId}")
    Admin findAdminByAdminId(String workId);
}
