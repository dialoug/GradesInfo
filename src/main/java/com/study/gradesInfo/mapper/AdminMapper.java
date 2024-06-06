package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.Admin;
import com.study.gradesInfo.entity.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static java.time.LocalTime.now;

@Mapper
public interface AdminMapper {
    @Insert("insert into admin(workid, name, phonenumber, date) VALUES (#{workId},#{name},#{phoneNumber},now())")
    void addAdmin(Admin admin);

    @Delete("delete from admin where workid=#{workId}")
    void deleteAdmin(String workId);

    @Update("update admin set name=#{name},phonenumber=#{phoneNumber},date=now() where workid=#{workId}")
    void update(Admin admin);

    @Select("select workid from admin where name=#{username}")
    String findWorkIdByUsername(String username);


    @Select("select *from admin")
    List<Admin> getAllAdmin();

    @Select("select * from admin where workid=#{workId}")
    Admin findAdminByAdminId(String workId);

    @Select("select * from user where username=(select username from user_type where typeid=#{workId})")
    User findUserByWorkId(String workId);
}
