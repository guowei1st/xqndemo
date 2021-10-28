package com.xqn.exception;

public class UserNotExistEception   extends  RuntimeException{
    public UserNotExistEception() {
        super("用户不存在");
    }
}
