package com.wows.commonutils.ordervo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UcenterMemberVoOrder {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "微信号")
    private String vxopenid;

    @ApiModelProperty(value = "性别：1女，2男，0隐藏")
    private Boolean sex;

    @ApiModelProperty(value = "昵称")
    private String nickname;

}
