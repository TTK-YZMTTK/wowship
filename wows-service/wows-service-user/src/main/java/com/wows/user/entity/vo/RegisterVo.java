package com.wows.user.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterVo {

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别：1女，2男，0隐藏")
    private Boolean sex;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "验证码")
    private String code;

}
