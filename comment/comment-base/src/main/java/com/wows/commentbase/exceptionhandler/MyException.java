package com.wows.commentbase.exceptionhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException{
    private Integer code;//异常信息
    private String message;//状态码
}
