package com.wows.order.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ShipOrder对象", description="")
public class ShipOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "舰船id")
    private String shipId;

    @ApiModelProperty(value = "舰船名称")
    private String shipName;

    @ApiModelProperty(value = "舰船简述")
    private String shipDescription;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String userNickname;

    @ApiModelProperty(value = "舰船类型（0银币，1金币，2全局，3煤炭，4钢铁，5研发局，6造船厂）")
    private Integer type;

    @ApiModelProperty(value = "舰船价格")
    private Integer price;

    @ApiModelProperty(value = "支付状态（0未支付，1已支付）")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除（0未删除，1已删除）")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
