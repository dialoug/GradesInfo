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
    public void addClassAcademy(String classId, String academyId) {
        departmentMapper.addClassAcademy(classId, academyId);
        departmentMapper.updateClassNumber(academyId);
    }

    @Override
    public void deleteAcademy(String academyId) {
        //departmentMapper.deleteClassByAcademyId(academyId);
        //删除本体
        departmentMapper.deleteAcademy(academyId);
        //删除班级关联表
        departmentMapper.deleteClass_Academy(academyId);
        //删除教师关联表
        departmentMapper.deleteTeacher_Academy(academyId);
    }

    @Override
    public void deleteClass(String classId) {
        departmentMapper.deleteClass(classId);
        System.out.println(classId + "删除班级");
        departmentMapper.deleteClassAcademyByClassId(classId);
        departmentMapper.decClassNumber(departmentMapper.getAcademyByClassId(classId).getAcademyId());
    }

    @Override
    public void updateClass(Class clas, String academyId) {
        departmentMapper.updateClass(clas);
        departmentMapper.updateClassAcademyId(clas.getClassId(), academyId);
        departmentMapper.updateClassNumber(academyId);
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
    public List<Class> getClassList() {
        return departmentMapper.getClassList();
    }

    @Override
    public Academy getAcademyByClassId(String classId) {
        return departmentMapper.getAcademyByClassId(classId);
    }

    @Override
    public List<Class> getNoAcademyClass() {
        return departmentMapper.getNoAcademyClass();
    }

    @Override
    public Academy getAcademyByTeacherId(String teacherId) {
        return departmentMapper.getAcademyByTeacherId(teacherId);
    }

    @Override
    public Class getClassByStudentId(String studentId) {
        return departmentMapper.getClassByStudentId(studentId);
    }

    @Override
    public void updateAcademy(Academy academy) {
        departmentMapper.updateAcademy(academy);
    }

}
