package com.xqn.controller;

import com.xqn.Dao.PlanMapper;
import com.xqn.Dto.ReturnDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;
@Api(tags = "计划相关接口")
@Controller
public class planController {
    @Autowired
    PlanMapper planMapper;

    @ApiOperation("添加推荐计划")
    @ResponseBody
    @PostMapping("/uploadplantj")
    public ReturnDto sc(@RequestParam("username") String username,
                     @RequestParam("content") String content,
                     @RequestParam("old") String old,
                     @RequestParam("starttime") String starttime
    ) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(new Date());
        Integer re=planMapper.insertPlanTj(username,content,starttime,date,old);
        if(re==1) {
            return new ReturnDto(200, "success", "添加新计划成功");
        }else {
            return new ReturnDto(400, "error", "更新失败,re="+re);
        }

    }

    @ApiOperation("添加自定义计划")
    @ResponseBody
    @PostMapping("/uploadplandiy")
    public ReturnDto sc2(@RequestParam("username") String username,
                     @RequestParam("content") String content,
                     @RequestParam("old") String old,
                     @RequestParam("starttime") String starttime,
                     @RequestParam("award") String award

    ) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(new Date());
        Integer re=planMapper.insertPlanDiy(username,content,starttime,date,old,award);
        if(re==1) {
            return new ReturnDto(200, "success", "添加新计划成功");
        }else {
            return new ReturnDto(400, "error", "更新失败,re="+re);
        }



    }
    @ApiOperation("查找某用户制定的所有计划")
    @ResponseBody
    @GetMapping("/findplan")
    public ReturnDto sc2(@RequestParam("username") String username

    ) {
        return new ReturnDto(200,planMapper.findplan(username),"findplan");

    }

}
