package com.wows.ships.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AllShips对象", description="")
public class AllShips implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "舰船id")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "舰船名字")
    private String name;

    @ApiModelProperty(value = "舰船类型（0银币，1金币，2全局，3煤炭，4钢铁，5研发局，6造船厂）")
    private Integer type;


}
