package com.wows.commonutils.ordervo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShipVoOrder {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "舰船id")
    private String id;

    @ApiModelProperty(value = "舰船名字")
    private String name;

    @ApiModelProperty(value = "舰船等级")
    private String grade;

    @ApiModelProperty(value = "舰船生命值")
    private String hp;

    @ApiModelProperty(value = "价格")
    private Integer price;

    @ApiModelProperty(value = "舰船描述")
    private String description;

    @ApiModelProperty(value = "舰船类型（0银币，1金币，2全局，3煤炭，4钢铁，5研发局，6造船厂）")
    private Integer type;

}
