package com.wows.ships.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
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
 * @since 2021-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoldShips对象", description="")
public class GoldShips implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "舰船id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "舰船名字")
    private String name;

    @ApiModelProperty(value = "舰船等级")
    private String grade;

    @ApiModelProperty(value = "舰船生命值")
    private String hp;

    @ApiModelProperty(value = "舰船航速")
    private Float speed;

    @ApiModelProperty(value = "舰船隐蔽范围")
    @TableField("Detection_range")
    private Float detectionRange;

    @ApiModelProperty(value = "打舵时间")
    @TableField("Steering_time")
    private Float steeringTime;

    @ApiModelProperty(value = "价格")
    private Integer price;

    @ApiModelProperty(value = "舰船描述")
    private String description;

    @ApiModelProperty(value = "是否销售（1是，0否）")
    private Boolean sale;

    @ApiModelProperty(value = "上架时间")
    private Date sellDate;

    @ApiModelProperty(value = "下架时间")
    private Date stopDate;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;


}
