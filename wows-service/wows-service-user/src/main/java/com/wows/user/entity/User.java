package com.wows.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author OldFish
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "UID", type = IdType.INPUT)
    private String uid;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "微信号")
    private String vxopenid;

    @ApiModelProperty(value = "性别：1女，2男，0隐藏")
    private Boolean sex;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "是否被删除")
    @TableField("isDisable")
    private Boolean isDisable;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT )
    private Date gmtCreate;

    @ApiModelProperty(value = "更改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
