package com.wows.order.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.io.FileFilter;
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
 * @since 2021-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PayLog对象", description="")
public class PayLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "交易支付时间")
    private Date payTime;

    @ApiModelProperty(value = "支付价格")
    private Integer totalFee;

    @ApiModelProperty(value = "交易流水号")
    private String transactionId;

    @ApiModelProperty(value = "交易状态（0未完成，1已完成）")
    private Integer tradeState;

    @ApiModelProperty(value = "舰船类型（0银币，1金币，2全局，3煤炭，4钢铁，5研发局，6造船厂）")
    private Integer payType;

    @ApiModelProperty(value = "逻辑删除（0未删除，1已删除）")
    @TableField("isDisable")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
