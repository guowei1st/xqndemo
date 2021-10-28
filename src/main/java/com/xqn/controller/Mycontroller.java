package com.xqn.controller;

import com.xqn.Dto.GetContent;
import com.xqn.Dto.ReturnDto;
import com.xqn.entities.syDto;
import com.xqn.entities.syDto2;
import com.xqn.Dao.MyControllerMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags="互动版非互动版的接口")
@Controller
public class Mycontroller<T> {
    @Autowired
    MyControllerMapper myControllerMapper;


    @ApiOperation("互动版数据展示接口")
    @ResponseBody
    @GetMapping("/hudong")
    public ReturnDto showsy(@ApiParam("用户名") @RequestParam("username") String username) {
        String week1=getWeekContent1(username,1+"");
        String week2=getWeekContent1(username,2+"");
        String week3=getWeekContent1(username,3+"");
        String week4=getWeekContent1(username,4+"");
        String week5=getWeekContent1(username,5+"");
        String week6=getWeekContent1(username,6+"");
        String week7=getWeekContent1(username,7+"");
        String target=getTarget(username);
        String award=getAward(username);
        String comment=getCommnet(username);
        syDto st = new syDto(week1,week2,week3,week4,week5,week6,week7,target,award,comment);
        return new ReturnDto(200,st,"shouye");
    }



    @ApiOperation("非互动版互动版数据展示接口")
    @ResponseBody
    @GetMapping("/feihudong")
    public ReturnDto showsy2(@RequestParam("username") String username) {
        String week1=getWeekContent1(username,1+"");
        String week2=getWeekContent1(username,2+"");
        String week3=getWeekContent1(username,3+"");
        String week4=getWeekContent1(username,4+"");
        String week5=getWeekContent1(username,5+"");
        String week6=getWeekContent1(username,6+"");
        String week7=getWeekContent1(username,7+"");
        String target=getTarget(username);
        String award=getAward(username);
        syDto2 st = new syDto2(week1,week2,week3,week4,week5,week6,week7,target,award);
         return new ReturnDto(200,st,"shouye");
    }


    @ApiOperation("查询周？的计划")
    @ResponseBody
    @GetMapping("/planlook")
    public ReturnDto planMon(@RequestParam("username") String username,@ApiParam("周几") @RequestParam("weeknum") String weeknum) {
        return new ReturnDto(200,chaxunplan(username,weeknum),"查询周"+weeknum+"的计划");
    }

    /*
    选择新Plan
     */
    @ApiOperation("更新周？的计划?")
    @ResponseBody
    @GetMapping("/checkplan")
    public ReturnDto checkplanMon(@RequestParam("username") String username,@ApiParam("周几，需要填数字") @RequestParam("weeknum") String weeknum,@ApiParam("plan的Id") @RequestParam("planId") String planid) {
        myControllerMapper.updatePlanPre(username,weeknum);
        Integer re= myControllerMapper.updatePlan(username,weeknum,planid);
        if(re==1) {
            return new ReturnDto(200, "success", "确认新计划");
        }else {
            return new ReturnDto(400, "error", "更新失败,re="+re);
        }
    }


    /*
    查询某天可以选的plan
     */
    public GetContent[] chaxunplan(String username, String i) {
        return myControllerMapper.getContent(username,i);
    }


    public String getWeekContent1(String username,String i) {
        return   myControllerMapper.getWeekiContent(username,i);
    }


    public String getTarget(String username) {
        return myControllerMapper.getTarget(username);
    }

    public String getAward(String username) {
        return myControllerMapper.getAward(username);
    }

    public String getCommnet(String username) {
        return myControllerMapper.getCommnet(username);
    }



}