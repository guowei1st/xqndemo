package com.xqn.controller;
import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
@Api(tags = "登录相关接口")
@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @ResponseBody
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        Model model,
                        HttpSession session){



        //System.out.println(username+ "  "+flag);

        session.setAttribute("page","0");
        session.setAttribute("stupage","0");

        Object key=null;
        Object value=null;
        String sql=null;
        String leix=null;

        sql= "select count(*) from t_stuLogin where username='"+username+"' and password='"+password+"'";
        leix="stu";



       // System.out.println(sql);
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);

        for (Map<String, Object> map1 : list) {
           Set<Map.Entry<String, Object>> entries = map1.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    key = entry.getKey( );
                    value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        if(value.toString().equals("1")){
            return "true123";
        }else{
            return  "F";
        }
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String date=sdf.format(new Date());
//
//       // System.out.println(date);
//        sql="insert into t_loginlog values ('"+username+"','" +leix+"','"+  date +"')";
//
//          jdbcTemplate.update(sql);
//
//
//        if(value.toString().equals("1")){
//            session.setAttribute("loginUser",username);
//            if(leix.equals("stu")){
//                session.setAttribute("stuUser",username);
//                session.setAttribute("teaUser",null);
//                flag="1";
//                map.put("flag",flag);
//                sql="select * from t_stulogin where username='"+username+"';";
//                 list =  jdbcTemplate.queryForList(sql);
//                for (Map<String, Object> map1 : list) {
//                    Set<Map.Entry<String, Object>> entries = map1.entrySet( );
//                    if(entries != null) {
//                        Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                        while(iterator.hasNext( )) {
//                            Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                            key = entry.getKey( );
//                            value = entry.getValue();
//                           // System.out.println(key+":"+value);
//                            map.put(key.toString(),value.toString());
//                        }
//                    }
//                }
//
//
//               // System.out.println(value.toString());
//                sql="select teacher from t_class where class='"+value.toString()+"';";
//
//                list =  jdbcTemplate.queryForList(sql);
//                //System.out.println(sql);
//                int i=1;
//                for (Map<String, Object> map1 : list) {
//                    Set<Map.Entry<String, Object>> entries = map1.entrySet( );
//                    if(entries != null) {
//                        Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                        while(iterator.hasNext( )) {
//                            Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                            key = entry.getKey( );
//                            value = entry.getValue();
//                           // System.out.println(key+":"+value);
//                            if(key.toString().equals("teacher")){
//
//                                map.put(key.toString()+i,value.toString());
//                                i++;
//                            }else{
//
//                                map.put(key.toString(),value.toString());
//                            }
//                        }
//                    }
//                }
//
//                sql="select rank from t_evo where stuname='"+map.get("name")+"';";
//
//                list =  jdbcTemplate.queryForList(sql);
//                //System.out.println(sql);
//                int ranksum=0;
//                for (Map<String, Object> map1 : list) {
//                    Set<Map.Entry<String, Object>> entries = map1.entrySet( );
//                    if(entries != null) {
//                        Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                        while(iterator.hasNext( )) {
//                            Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                            key = entry.getKey( );
//                            value = entry.getValue();
//                            // System.out.println(key+":"+value);
//                            if(key.toString().equals("rank")){
//
//                                ranksum+=Integer.parseInt(value.toString());
//                            }
//                        }
//                    }
//                }
//                System.out.println(ranksum);
//
//                map.put("rank",ranksum);
//
//
//
//
//               // System.out.println(map);
//
//
//                return "stu/stuindex";
//            }else{
//                session.setAttribute("teaUser",username);
//                session.setAttribute("stuUser",null);
//                flag="2";
//                map.put("flag",flag);
//                sql="select * from t_tealogin where username='"+username+"';";
//                list =  jdbcTemplate.queryForList(sql);
//                for (Map<String, Object> map1 : list) {
//                    Set<Map.Entry<String, Object>> entries = map1.entrySet( );
//                    if(entries != null) {
//                        Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                        while(iterator.hasNext( )) {
//                            Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                            key = entry.getKey( );
//                            value = entry.getValue();
//                            // System.out.println(key+":"+value);
//                            map.put(key.toString(),value.toString());
//                        }
//                    }
//                }
//
//
//                // System.out.println(value.toString());
//                sql="select class from t_class where teacher='"+map.get("name")+"';";
//
//                session.setAttribute("Teaname",map.get("name"));
//                list =  jdbcTemplate.queryForList(sql);
//                //System.out.println(sql);
//                int i=1;
//                List<String> list2=new ArrayList<>();
//                for (Map<String, Object> map1 : list) {
//                    Set<Map.Entry<String, Object>> entries = map1.entrySet( );
//                    if(entries != null) {
//                        Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
//                        while(iterator.hasNext( )) {
//                            Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
//                            key = entry.getKey( );
//                            value = entry.getValue();
//                            // System.out.println(key+":"+value);
//                            if(key.toString().equals("class")){
//
//                               list2.add(value.toString());
//
//                            }else{
//
//                                map.put(key.toString(),value.toString());
//                            }
//                        }
//                    }
//                }
//
//                map.put("class",list2);
//                System.out.println(map);
//                return "tea/teaindex";
//            }
//
//
//        }else {
//
//            if(flag.trim().equals("1")){
//                map.put("msg","请输入正确的学生账号密码");
//            }else{
//                map.put("msg","请输入正确的教师账号密码");}
//            return "login";
//        }



    }
    @ResponseBody
    @PostMapping(value = "/zhuce")
    public String zhuce(@RequestParam("name") String name,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        Model model,
                        HttpSession session) {
        Object key=null;
        Object value=null;

        String sql=null;
        String leix=null;




        if(cheakcz(username).equals("yes")){
            return "yicunzai";
        }else{
            sql="insert into t_stulogin (name,username,password) values('"+name+"','"+username+"','"+password+"')";
            jdbcTemplate.execute(sql);
            if(cheakcz(username).equals("yes"))
                return  "success";
        }
            return "error";
    }


    public String cheakcz(String username){

        Object key=null;
        Object value=null;

        String sql=null;
        String leix=null;

        sql= "select count(*) from t_stuLogin where username='"+username+"'";

        // System.out.println(sql);
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);

        for (Map<String, Object> map1 : list) {
            Set<Map.Entry<String, Object>> entries = map1.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    key = entry.getKey( );
                    value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        if(value.toString().equals("1")){

            return "yes";
        }else{

            return  "no";
        }
    }

    }
