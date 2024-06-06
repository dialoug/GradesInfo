package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Match;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.MatchGService;
import com.study.gradesInfo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchGrade")
public class match_gradeController {
//
//        @Autowired
//        private MatchGService matchGService;
//
//        //管理员权限
//        @PostMapping("add")
//        public Result addMatch(@RequestBody @Validated Match match) {
//            if (matchGService.getMatchById(match.getMatchId()) == null) {
//                matchGService.addMatch(match);
//            } else
//                return Result.error("该项目已存在！");
//            return Result.success();
//        }
//
//        @PostMapping("addProject")
//        public Result addProject(@RequestParam String matchId, @RequestParam String projectId) {
//            if (matchGService.getMatchProject(matchId, projectId) == null) {
//                matchGService.addMatchProject(matchId, projectId);
//            } else
//                return Result.error("该项目已存在！");
//            return Result.success();
//        }
//
//        @PostMapping("deleteProject")
//        public Result deleteProject(@RequestParam String matchId, @RequestParam String projectId) {
//
//            matchGService.deleteMatchProject(matchId, projectId);
//
//            return Result.success();
//        }
//
//
//        //管理员权限
//        @PostMapping("/delete")
//        public Result deleteMatch(@RequestBody String matchId) {
//            System.out.println(matchId + "删除项目");
//            matchGService.deleteMatch(matchId);
//            return Result.success();
//        }
//
//        //管理员权限
//        @PutMapping("/edit")
//        public Result<Match> matchEdit(@RequestBody Match match) {
//            System.out.println(match + "修改项目");
//            matchGService.updateMatch(match);
//            return Result.success();
//        }
//
//        @GetMapping("/list")
//        public Result<List<Match>> matchList() {
//            List<Match> matches = matchGService.getMatchList();
//            return Result.success((matches));
//        }
//
//        @GetMapping("/getMatch")
//        public Result<Match> matchInfo(@RequestParam String matchId) {
//            return Result.success(matchGService.getMatchById(matchId));
//        }

}


