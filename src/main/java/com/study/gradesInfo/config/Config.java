package com.study.gradesInfo.config;

import com.study.gradesInfo.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor).excludePathPatterns(
                "/user/login",
                "/user/register",
                "/score/list",
                "/score/search",
                "/match/getMatch",
                "/match/list",
                "/project/list",
                "/project/getListByMatchId",
                "/student/getStudentById",
                "/department/academyByClassId",
                "/department/classByStudentId"
        );

    }

}
