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
    public void deleteAcademy(String academyId) {
        departmentMapper.deleteClassByAcademyId(academyId);
        departmentMapper.deleteAcademy(academyId);
    }

    @Override
    public void deleteClass(String classId) {
        departmentMapper.deleteStudentByClassId(classId);
        departmentMapper.deleteClass(classId);
    }

    @Override
    public void updateClass(Class clas) {
        departmentMapper.updateClass(clas);
    }

    @Override
    public void updateClassAcademyId(String classId, String academyId) {
        departmentMapper.updateClassAcademyId(classId, academyId);
    }

    @Override
    public List<Academy> getAcademyList() {
        return departmentMapper.getAcademyList();
    }

    @Override
    public List<Class> getClassListByAcademyId(String academyId) {
        return departmentMapper.getClassListByAcademyId(academyId);
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
        departmentMapper.updateAcademy(academy);
    }

}
