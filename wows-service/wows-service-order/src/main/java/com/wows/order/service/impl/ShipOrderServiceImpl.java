package com.wows.order.service.impl;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.commonutils.ordervo.UcenterMemberVoOrder;
import com.wows.order.client.ShipClient;
import com.wows.order.client.UserClient;
import com.wows.order.entity.ShipOrder;
import com.wows.order.mapper.ShipOrderMapper;
import com.wows.order.service.ShipOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wows.order.util.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-04-16
 */
@Service
public class ShipOrderServiceImpl extends ServiceImpl<ShipOrderMapper, ShipOrder> implements ShipOrderService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ShipClient shipClient;

    //生成订单的方法
    @Override
    public String creatOrder(String shipId, String uid) {
        ShipOrder shipOrder = new ShipOrder();
        UcenterMemberVoOrder userById = userClient.findUserById(uid);
        ShipVoOrder shipInfoById = shipClient.findShipInfoById(shipId);
        shipOrder.setOrderNo(OrderNoUtil.getOrderNo());
        shipOrder.setShipId(shipId);
        shipOrder.setUserNickname(userById.getNickname());
        shipOrder.setShipName(shipInfoById.getName());
        shipOrder.setShipDescription(shipInfoById.getDescription());
        shipOrder.setUserId(uid);
        shipOrder.setType(shipInfoById.getType());//支付所需货币类型
        shipOrder.setPrice(shipInfoById.getPrice());
        shipOrder.setStatus(0); //订单状态（0：未支付 1：已支付）
        baseMapper.insert(shipOrder);

        return shipOrder.getOrderNo();
    }
}
