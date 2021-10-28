package com.xqn.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(tags = "Note相关接口")
@Controller
public class FindnoteController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/findbyusername")
    public String sc(@RequestParam("username") String username){
        Object key=null;
        Object value=null;
        String sql=null;
        String leix=null;
        sql= "select * from t_note where username='"+username+"'";
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
                    info=info+key+":"+value+"\n";
//                        info+=key.toString();
//                        info+=":"+value.toString()+"  ";
                }
            }
        }
        return  info;
    }


    @ResponseBody
    @PostMapping("/findbybeizhu")
    public String sc2(@RequestParam("username") String username,
                      @RequestParam("beizhu") String beizhu){
        Object key=null;
        Object value=null;
        String sql=null;
        String leix=null;
        sql= "select * from t_note where username='"+username+"' and beizhu like '%"+beizhu+"%'";
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
                    info=info+key+":"+value+"\n";
//                        info+=key.toString();
//                        info+=":"+value.toString()+"  ";
                }
            }
        }
        return  info;
    }

}
