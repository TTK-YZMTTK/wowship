package com.wows.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wows.commonutils.Ret;
import com.wows.order.entity.ShipOrder;
import com.wows.order.service.ShipOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-04-16
 */
@RestController
@RequestMapping("/wowsservice/shiporder")
public class ShipOrderController {

    @Autowired
    private ShipOrderService shipOrderService;

    //生成订单的方法
    @PostMapping("creatOrder/{shipId}/{uid}")
    @ApiOperation(value = "根据舰船id，用户id生成订单")
    public Ret creatOrder(@PathVariable String shipId,@PathVariable String uid){
        String orderNo = shipOrderService.creatOrder(shipId,uid);
        return Ret.ok().data("orderNo",orderNo);
    }

    //根据订单号查询订单
    @GetMapping("selectOrder/{orderNo}")
    public Ret selectOrder(@PathVariable String orderNo){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("order_No",orderNo);
        ShipOrder order = shipOrderService.getOne(wrapper);
        return Ret.ok().data("order",order);
    }
}

