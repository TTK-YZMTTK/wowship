package com.wows.ships.entity.vo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ShipVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "舰船名字")
    private String name;

    @ApiModelProperty(value = "下级舰船名字")
    private String parentName;

    @ApiModelProperty(value = "舰船等级")
    private String grade;

    @ApiModelProperty(value = "舰船生命值")
    private String hp;

    @ApiModelProperty(value = "价格")
    private Integer price;

    @ApiModelProperty(value = "研发所需上级经验")
    private Integer exp;


}
