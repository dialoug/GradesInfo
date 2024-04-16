package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Insert("insert into academy(academyid, name, date) VALUES(#{AcademyId},#{Name},now())  ")
    void addAcademy(Academy academy);

    @Insert("insert into class(classid, name, academyid, date) VALUES (#{ClassId},#{ClassName},#{AcademyId},now())")
    void addClass(Class clas);


    @Update("update academy set name=#{Name},academyid=#{AcademyId},date=now() where id=#{Id}")
    void updateAcademy(Academy academy);

    @Update("update class set academyid=#{academyId},date=now() where academyid=(select academyid from academy where id=#{Id}) ")
    boolean updateClassAcademyId(Academy academy);

    @Update("update class set name=#{Name},classid=#{ClassId},date=now() where id=#{Id}")
    void updateClass(Class clas);

    @Update("update student set classid=#{ClassId},date=NOW() where classid=(select classid from class where id=#{Id})")
    boolean updateStudentClassId(Class clas);

    @Select("select * from academy")
    List<Academy> getAcademyList();

    @Select("select * from class where academyid=#{academyId}")
    List<Class> getClassList(String academyId);

    @Select("select * from academy where academyid=#{academyId}")
    Academy findAcademyById(String academyId);

    @Select("select * from class where academyid=#{classId}")
    Class findClassById(String classId);

    void deleteClassByAcademyId(String academyId);

    void deleteAcademy(String academyId);

    void deleteClass(String classId);
}
