package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Select("insert into user(username, password, usertype, date)" + "value (#{username},#{password},#{type},now())")
    void addUser(String username, String password, Integer type);

    @Update("update user set password=#{newPassword},date=now() where username=#{username}")
    void updatePwd(String newPassword, String username);

    @Insert("insert into user_type(username,typeid,type,date) values (#{username},#{typeId},#{type},now())")
    void addUserType(String username, String typeId, int type);
}
