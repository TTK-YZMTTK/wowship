package com.wows.user.entity.vo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CreatePageVo {

    @ApiModelProperty(value = "查询开始时间",example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间",example = "2019-12-01 10:10:10")
    private String end;
}
