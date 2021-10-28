package com.xqn.controller;

import com.xqn.entities.user;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Api(tags = "个人信息相关接口")
@Controller
public class UserInfoController {
    @Autowired
        private JdbcTemplate jdbcTemplate;
        @ResponseBody
        @GetMapping("/userinfo")
        public user userinfo(@RequestParam("username") String username){
            Object key=null;
            Object value=null;
            String sql=null;
            String leix=null;

            sql= "select * from t_stuLogin where username='"+username+"'";


            user us=new user();

            // System.out.println(sql);
            List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
            String info=null;
            for (Map<String, Object> map1 : list) {
                Set<Map.Entry<String, Object>> entries = map1.entrySet( );
                if(entries != null) {
                    Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                    while(iterator.hasNext( )) {
                        Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                        key = entry.getKey( );
                        value = entry.getValue();
                        if(key.equals("name")){
                            us.setName(value+"");
                        }
                        if(key.equals("username")){
                            us.setUsername(value+"");
                        }
                        if(key.equals("password")){
                            us.setPassword(value+"");
                        }
                        if(key.equals("class")){
                            us.setClass1(value+"");
                        }
                      info=info+key+":"+value+"\n";
//                        info+=key.toString();
//                        info+=":"+value.toString()+"  ";
                    }
                }
            }


            return  us;
        }


            @ResponseBody
            @PostMapping("/sc")
            public String sc(@RequestParam("username") String username,
                             @RequestParam("name") String name,
                             @RequestParam("beizhu") String beizhu,
                             @RequestParam("picture") String picture){

                Object key=null;
                Object value=null;
                String sql=null;
                String leix=null;
                try {
                    sql= "insert into t_note(username,name,beizhu,picture) values('"+username+"','"+name+"','"+beizhu+"','"+picture+"')" ;
                    jdbcTemplate.execute(sql);
                }catch (Exception e) {
                    return "Error";
                }
                return "success";
            }


    }

