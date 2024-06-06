package com.study.gradesInfo.mapper;

import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Insert("insert into academy(academyid, name,classnumber ,date) VALUES(#{academyId},#{name},0,now())  ")
    void addAcademy(Academy academy);

    @Insert("insert into class(classid, name, studentnumber,date) VALUES (#{classId},#{name},0,now())")
    void addClass(Class clas);

    @Insert("insert into class_academy(classid, academyid)VALUES (#{classId},#{academyId})")
    void addClassAcademy(String classId, String academyId);

    @Update("UPDATE academy SET classnumber=(SELECT COUNT(*) AS classnumber FROM class_academy where academyId=#{academyId}) WHERE academyid=#{academyId}")
    void updateClassNumber(String academyId);

    @Update("UPDATE academy SET classnumber=classnumber-1 WHERE academyid=#{academyId};")
    void decClassNumber(String academyId);


    @Delete("delete from academy where academyid=#{academyId}")
    void deleteAcademy(String academyId);

    @Delete("delete from class where classid=#{classId}")
    void deleteClass(String classId);


    @Update("update class_academy set academyid=null where academyid=#{academyId}")
    void deleteClass_Academy(String academyId);

    @Update("update academy set name=#{name},date=now() where id=#{id}")
    void updateAcademy(Academy academy);

    @Update("update class_academy set academyid=#{academyId} where classid=#{classId}")
    boolean updateClassAcademyId(String classId, String academyId);

    @Update("update class set name=#{name},date=now() where classid=#{classId}")
    void updateClass(Class clas);

    @Select("select * from academy")
    List<Academy> getAcademyList();

    @Select("select * from class where classid in" +
            "(select classid from class_academy where academyid=#{academyId})")
    List<Class> getClassListByAcademyId(String academyId);

    @Select("select * from academy where academyid=#{academyId}")
    Academy findAcademyById(String academyId);

    @Select("select * from class where classid=#{classId}")
    Class findClassById(String classId);

    @Select("select * from class")
    List<Class> getClassList();

    @Select("select * from academy where academyid=" +
            "(select academyid from class_academy where classid=#{classId})")
    Academy getAcademyByClassId(String classId);

    @Select("select * from class where classid in (select classid from class_academy where academyid is null)")
    List<Class> getNoAcademyClass();

    @Select("select * from academy where academyid=(select academyid from teacher_academy where teacherid=#{teacherId})")
    Academy getAcademyByTeacherId(String teacherId);

    @Update("update teacher_academy set academyid=null where academyid=#{academyId}")
    void deleteTeacher_Academy(String academyId);

    @Select("select * from class where classid=(select classid from student_class where studentid=#{studentId})")
    Class getClassByStudentId(String studentId);

    @Delete("delete from class_academy where classid=#{classId}")
    void deleteClassAcademyByClassId(String classId);
}
