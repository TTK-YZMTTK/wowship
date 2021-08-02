package com.wows.user.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NickpageVo {

    @ApiModelProperty(value = "昵称")
    private String nickname;

}
