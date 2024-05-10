package com.study.gradesInfo.controller;

import com.study.gradesInfo.entity.Match;
import com.study.gradesInfo.entity.Project;
import com.study.gradesInfo.entity.utils.Result;
import com.study.gradesInfo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    //管理员权限
    @PostMapping("add")
    public Result addMatch(@RequestBody @Validated Match match) {
        if (matchService.getMatchById(match.getMatchId()) == null) {
            matchService.addMatch(match);
        } else
            return Result.error("该项目已存在！");
        return Result.success();
    }

    @PostMapping("addProject")
    public Result addProject(@RequestParam String matchId, @RequestParam String projectId) {
        if (matchService.getMatchProject(matchId, projectId) == null) {
            matchService.addMatchProject(matchId, projectId);
        } else
            return Result.error("该项目已存在！");
        return Result.success();
    }

    @PostMapping("deleteProject")
    public Result deleteProject(@RequestParam String matchId, @RequestParam String projectId) {

        matchService.deleteMatchProject(matchId, projectId);

        return Result.success();
    }


    //管理员权限
    @PostMapping("/delete")
    public Result deleteMatch(@RequestBody String matchId) {
        System.out.println(matchId + "删除项目");
        matchService.deleteMatch(matchId);
        return Result.success();
    }

    //管理员权限
    @PutMapping("/edit")
    public Result<Match> matchEdit(@RequestBody Match match) {
        System.out.println(match + "修改项目");
        matchService.updateMatch(match);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Match>> matchList() {
        List<Match> matches = matchService.getMatchList();
        return Result.success((matches));
    }

    @GetMapping("/getMatch")
    public Result<Match> matchInfo(@RequestParam String matchId) {
        return Result.success(matchService.getMatchById(matchId));
    }

}
