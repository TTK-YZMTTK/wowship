package com.wows.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2021-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_message")
@ApiModel(value="Message对象", description="")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "银币")
    private Integer silver;

    @ApiModelProperty(value = "金币")
    private Integer gold;

    @ApiModelProperty(value = "公用经验")
    private Integer general;

    @ApiModelProperty(value = "煤炭")
    private Integer coal;

    @ApiModelProperty(value = "钢铁")
    private Integer steel;

    @ApiModelProperty(value = "研发点")
    private Integer developmentSites;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;


}
