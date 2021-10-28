package com.xqn.controller;

import com.xqn.Dao.CommentMapper;
import com.xqn.Dto.ReturnDto;
import com.xqn.component.Myfunction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;
@Api(tags = "留言相关接口")
@Controller
public class CommentController {
    @Autowired
    CommentMapper commentMapper;

    @ApiOperation("添加留言")
    @ResponseBody
    @PostMapping("/uploadly")
    public ReturnDto uploadly(@RequestParam("username") String username,
                     @RequestParam("comment") String comment
                     ) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(new Date());
        Integer re=commentMapper.upLoadComment(username,comment,date);
        if(re==1) {
            return new ReturnDto(200, "success", "添加留言成功");
        }else {
            return new ReturnDto(400, "error", "更新失败,re="+re);
        }
    }

    @ApiOperation("查找用户的留言")
    @ResponseBody
    @GetMapping("/findlybyusername")
    public ReturnDto findlybyusername(@RequestParam("username") String username
    ) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(new Date());
        return new ReturnDto(200, commentMapper.findCommentByUsername(username), "查找用户的留言");
    }

    @ApiOperation("查找孩子的家长留言")
    @ResponseBody
    @GetMapping("/findlybychild")
    public ReturnDto findlybychild(@RequestParam("username") String username
    ) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(new Date());
        return new ReturnDto(200, commentMapper.findCommentByChild(username), "查找用户的留言");
    }




}

