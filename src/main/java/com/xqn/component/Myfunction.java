package com.xqn.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Myfunction {

    private  JdbcTemplate jdbcTemplate;
    public  String insert(String sql){

        Object key=null;
        Object value=null;

        String leix=null;
        System.out.println(sql);
        jdbcTemplate.execute(sql);
        return "success";
    }
}
