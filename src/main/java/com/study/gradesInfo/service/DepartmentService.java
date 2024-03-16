package com.study.gradesInfo.service;


import com.study.gradesInfo.entity.Academy;
import com.study.gradesInfo.entity.Class;

import java.util.List;

public interface DepartmentService {

    void addAcademy(Academy academy);

    void addClass(Class clas);

    List<Academy> getAcademyList();

    List<Class> getClassListByAcademyId(String academyId);

    Academy getAcademyById(String academyId);

    Class getClassById(String classId);

    void updateAcademy(Academy academy);

    void updateClass(Class clas);
}
