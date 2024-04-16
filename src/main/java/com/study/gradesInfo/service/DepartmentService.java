package com.study.gradesInfo.service;


import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;

import java.util.List;

public interface DepartmentService {

    void addAcademy(Academy academy);

    void addClass(Class clas);

    void addClassAcademy(String classId, String academyId);

    void deleteAcademy(String academyId);

    void deleteClass(String classId);

    void updateAcademy(Academy academy);

    void updateClass(Class clas);

    void updateClassAcademyId(String classId, String academyId);

    List<Academy> getAcademyList();

    List<Class> getClassListByAcademyId(String academyId);

    Academy getAcademyById(String academyId);

    Class getClassById(String classId);

}
