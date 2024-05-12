package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.user.User;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.UserService;
import com.study.gradesInfo.utils.JwtUtil;
import com.study.gradesInfo.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,20}$") String username, @Pattern(regexp = "^\\S{5,20}$") String password, String teacherId) {
        User u = userService.findByUsername(username);
        boolean haveTeacher = userService.findTeacherByTeacherId(teacherId);
        if (u == null) {
            if (haveTeacher == false) {
                return Result.error("非本校教师，无法注册");
            } else {
                userService.register(username, password, teacherId, 1);
                return Result.success("注册教师成功");
            }
        } else {
            return Result.error("用户名被占用");
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody Map<String, String> password, @RequestHeader("Authorization") String token) {
        String oldPassword = password.get("oldPassword");
        String newPassword = password.get("newPassword");
        String confPassword = password.get("confPassword");
        if (oldPassword.isEmpty() || newPassword.isEmpty() || confPassword.isEmpty())
            return Result.error("缺少参数");
        if (!newPassword.equals(confPassword))
            return Result.error(newPassword);
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        User confUser = userService.findByUsername(username);
        if (!confUser.getPassword().equals(oldPassword)) {
            return Result.error("原密码不正确");
        }
        userService.updatePwd(newPassword);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<User>> userList() {
        List<User> lu = userService.getUserList();
        return Result.success(lu);
    }

    @GetMapping("/userinfo")
    public Result<User> userInfo() {
        Map<String, Object> user = ThreadLocalUtil.get();
        String username = (String) user.get("username");
        User userinfo = userService.findByUsername(username);
        System.out.println(userinfo);
        return Result.success(userinfo);
    }

    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,20}$") String username, @Pattern(regexp = "^\\S{5,20}$") String password) {
        User u = userService.findByUsername(username);
        if (u == null) {
            return Result.error("用户名不存在");
        } else {
            if (password.equals(u.getPassword())) {

                Map<String, Object> claims = new HashMap<>();
                claims.put("id", u.getId());
                claims.put("username", u.getUserName());
                claims.put("usertype", u.getUserType());

                String token = JwtUtil.genToken(claims);
                ValueOperations operations = stringRedisTemplate.opsForValue();
                operations.set(token, token, JwtUtil.time, TimeUnit.MILLISECONDS);
                return Result.success(token);
            } else return Result.error("密码错误");
        }
    }

}
