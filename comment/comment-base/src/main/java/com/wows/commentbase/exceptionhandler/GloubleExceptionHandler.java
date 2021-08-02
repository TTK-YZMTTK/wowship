package com.wows.commentbase.exceptionhandler;


import com.wows.commonutils.Ret;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GloubleExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Ret error(Exception e) {
        e.printStackTrace();
        return Ret.error().message("执行了全局异常处理");
    }

    //自定义异常处理
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Ret error(MyException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return Ret.error().code(e.getCode()).message(e.getMessage());
    }
}
