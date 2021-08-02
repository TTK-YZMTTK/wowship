package com.wows.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Ret {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "信息描述")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap();

    //构造方法私有化
    private Ret(){}

    //成功的静态方法
    public static Ret ok(){
        Ret ret = new Ret();
        ret.setSuccess(true);
        ret.setCode(RetCode.SUCCESS);
        ret.setMessage("成功");
        return ret;
    }

    //失败的静态方法
    public static Ret error(){
        Ret ret = new Ret();
        ret.setSuccess(false);
        ret.setCode(RetCode.ERROR);
        ret.setMessage("失败");
        return ret;
    }

    public Ret code(Integer code){
        this.setCode(code);
        return this;
    }

    public Ret success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Ret message(String message){
        this.setMessage(message);
        return this;
    }

    public Ret data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public Ret data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

}
