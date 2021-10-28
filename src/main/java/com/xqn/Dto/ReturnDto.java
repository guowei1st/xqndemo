package com.xqn.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("返回json数据")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnDto<T> {

    // 返回码
    private int code;
    @ApiModelProperty("数据")
    private T data;
    // 返回码说明
    private String msg;

    public ReturnDto(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ReturnDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "returnDto{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
