package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Insert("insert into user(username, password, usertype, date) value (#{username},#{password},#{type},now())")
    void addUser(String username, String password, Integer type);

    @Insert("insert into user_type(username,typeid,type,date) values (#{username},#{typeId},#{type},now())")
    void addUserType(String username, String typeId, int type);

    @Delete("")
    void deleteUser();

    @Update("update user set password=#{newPassword},date=now() where username=#{username}")
    void updatePwd(String newPassword, String username);

    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Select("select typeid from user_type where username=#{username}")
    String getTypeIdByUserName(String username);
}
