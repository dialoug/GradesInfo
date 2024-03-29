package com.study.gradesInfo.service.impl;

import com.study.gradesInfo.entity.department.Academy;
import com.study.gradesInfo.entity.department.Class;
import com.study.gradesInfo.mapper.DepartmentMapper;
import com.study.gradesInfo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public void addAcademy(Academy academy) {
        departmentMapper.addAcademy(academy);
    }

    @Override
    public void addClass(Class clas) {
        departmentMapper.addClass(clas);
    }

    @Override
    public List<Academy> getAcademyList() {
        return departmentMapper.getAcademyList();
    }

    @Override
    public List<Class> getClassListByAcademyId(String academyId) {
        return departmentMapper.getClassList(academyId);
    }

    @Override
    public Academy getAcademyById(String academyId) {
        return departmentMapper.findAcademyById(academyId);
    }

    @Override
    public Class getClassById(String classId) {
        return departmentMapper.findClassById(classId);
    }

    @Override
    public void updateAcademy(Academy academy) {
        if (departmentMapper.updateClassAcademyId(academy))
            departmentMapper.updateAcademy(academy);

    }

    @Override
    public void updateClass(Class clas) {
        if (departmentMapper.updateStudentClassId(clas))
            departmentMapper.updateClass(clas);
    }

}
