package com.xqn.exception;

import com.xqn.exception.UserNotExistEception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


//    @ResponseBody
//    @ExceptionHandler(UserNotExistEception.class)
//    public  Map<String,Object> handlerException( Exception e){
//        Map<String,Object> map=new  HashMap<>();
//        map.put("code","user notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistEception.class)
    public  String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new  HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
