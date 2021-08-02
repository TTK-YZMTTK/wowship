package com.wows.order.service;

import com.wows.order.entity.ShipOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-04-16
 */
public interface ShipOrderService extends IService<ShipOrder> {
    //生成订单的方法
    String creatOrder(String shipId, String uid);
}
