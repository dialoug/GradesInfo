package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Student;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.entity.user.Teacher;
import com.study.gradesInfo.service.TeacherService;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //管理员权限
    @PostMapping("/add")
    public Result addTeacher(@RequestBody String teacherId, @RequestParam String academyId) {
        System.out.println(teacherId + "添加教师信息");
        if (teacherService.findTeacherByTeacherId(teacherId) == null) {
            teacherService.addTeacher(teacherId);
            teacherService.addTeacherAcademy(teacherId, academyId);
            return Result.success();
        } else {
            return Result.error("该教师ID已占用！");
        }
    }

    //管理员权限
    @PostMapping("/delete")
    public Result deleteTeacher(@RequestBody String teacherId) {
        System.out.println(teacherId + "delete");
        teacherService.deleteTeacher(teacherId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/updateInfo")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        System.out.println(teacher + "更新教师信息");
        return Result.success();
    }

    //管理员权限
    @PutMapping("/update")
    public Result updateTeacherAcademyId(@RequestParam String teacherId, @RequestParam String academyId) {
        System.out.println(teacherId + "edit" + academyId);
        teacherService.updateTeacherAcademyId(teacherId, academyId);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Teacher>> teacherList() {
        List<Teacher> lt = teacherService.getTeacherList();
        System.out.println(lt);
        return Result.success(lt);
    }

    @GetMapping("/listByAcademy")
    public Result<List<Teacher>> teacherListByAcademyId(@RequestParam String academyId) {
        System.out.println(academyId);
        List<Teacher> lt = teacherService.getTeacherByAcademy(academyId);
        System.out.println(lt);
        return Result.success(lt);
    }

    @GetMapping("/listNoAcademy")
    public Result<List<Teacher>> teacherListNoAcademy() {

        List<Teacher> lt = teacherService.getTeacherNoAcademy();
        System.out.println(lt + "无学院老师");
        return Result.success(lt);
    }

    @GetMapping("/getTeacherInfoByUserName")
    public Result<Teacher> teacherInfo() {
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        System.out.println(username);
        Teacher teacher = teacherService.findTeacherByUsername(username);
        System.out.println(teacher);
        return Result.success(teacher);
    }

    @GetMapping("/getByStudentId")
    public Result<Teacher> teacherListByStudentId(@RequestParam String studentId) {
        System.out.println("当前学生Id" + studentId);
        Teacher t = teacherService.getTeacherByStudentId(studentId);
        System.out.println("当前学生教师" + t);
        return Result.success(t);
    }


}
