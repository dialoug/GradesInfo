package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Insert("insert into academy(academyid, name, date) VALUES(#{academyId},#{name},now())  ")
    void addAcademy(Academy academy);

    @Insert("insert into class(classid, name, date) VALUES (#{classId},#{className},now())")
    void addClass(Class clas);

    @Delete("delete from class where classid=" +
            "(select * from class_academy where academyid=#{academyId})")
    void deleteClassByAcademyId(String academyId);

    @Delete("delete from academy where academyid=#{academyId}")
    void deleteAcademy(String academyId);

    @Delete("delete from class where classid=#{classId}")
    void deleteClass(String classId);

    @Delete("delete from student where studentid=" +
            "(select * from student_class where classid=#{classId})")
    void deleteStudentByClassId(String classId);

    @Update("update academy set name=#{Name},academyid=#{AcademyId},date=now() where id=#{Id}")
    void updateAcademy(Academy academy);

    @Update("update class_academy set academyid=#{academyId} where classid=#{classId}")
    boolean updateClassAcademyId(String classId, String academyId);

    @Update("update class set name=#{Name},date=now() where classid=#{classId}")
    void updateClass(Class clas);

    @Select("select * from academy")
    List<Academy> getAcademyList();

    @Select("select * from class where classid=" +
            "(select * from class_academy where academyid=#{academyId})")
    List<Class> getClassListByAcademyId(String academyId);

    @Select("select * from academy where academyid=#{academyId}")
    Academy findAcademyById(String academyId);

    @Select("select * from class where classid=#{classId}")
    Class findClassById(String classId);

}
