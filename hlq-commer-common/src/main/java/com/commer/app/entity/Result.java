package com.commer.app.entity;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


@ApiModel(value = "Rest result", description = "请求结果")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758059398L;
    @ApiModelProperty(value = "结果代码")
    private int code;
    @ApiModelProperty(value = "结果对象")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T value;
    private List<T> list;
    private String msg;

    public Result() {
        super();
        this.code = ResultCode.C200.getCode();
        this.msg = ResultCode.C200.getDesc();
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(ResultCode.C200.getCode());
        result.setValue(ResultCode.C200.desc);
        return result;
    }

    public static Result success(Object value){
        Result result = new Result();
        result.setCode(ResultCode.C200.getCode());
        result.setMsg(ResultCode.C200.desc);
        result.setValue(value);
        return result;
    }

    public static Result error(ResultCode code){
        return error(code, code.getDesc());
    }

    public static Result error(ResultCode code,String message){
        Result result = new Result();
        result.setCode(code.getCode());
        if(StringUtils.isBlank(message)){
            result.setMsg(code.getDesc());
        }else {
            result.setMsg(message);
        }
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +

                ", value=" + value +
                ", list=" + list +
                '}';
    }
}
