package com.xqn.controller;

import com.xqn.Dao.RankMapper;
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
@Api(tags = "积分排名相关接口")
@Controller
public class rankController {
    @Autowired
    RankMapper rankMapper;


    @ApiOperation("添加孩子积分获得")
    @ResponseBody
    @PostMapping("/uploadrank")
    public  ReturnDto uploadrank(@RequestParam("username")  String username,
                              @RequestParam("childid")  String childid,
                              @RequestParam("content")  String content,
                              @RequestParam("score")  String score,
                              @RequestParam("type")  String type){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        Integer re=rankMapper.upLoadRank(childid,type,score,content,username,date);
        if(re==1) {
            return new ReturnDto(200, "success", "添加新的积分成功");
        }else {
            return new ReturnDto(400, "error", "更新失败,re="+re);
        }

    }


    @ApiOperation("查找某天的积分排名情况")
    @ResponseBody
    @GetMapping("/findrankbyday")
    public ReturnDto findrankbyday(@RequestParam("day")  String day){

        return new ReturnDto(200,rankMapper.findRankByDay(day),"findrankbyday");

    }

    @ApiOperation("查找某段时间的积分排名情况")
    @ResponseBody
    @GetMapping("/findrankbytime")
    public ReturnDto findrankallbytime(@RequestParam("starttime")  String starttime,
                                       @RequestParam("endtime")  String endtime){
        return new ReturnDto(200,rankMapper.findrankallbytime(starttime,endtime),"findrankbytime");
    }


    @ApiOperation("查找目前所有积分排名情况")
    @ResponseBody
    @GetMapping("/findrank")
    public ReturnDto findrank(){
        return new ReturnDto(200,rankMapper.findRank(),"findrank");
    }

}
