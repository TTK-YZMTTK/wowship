package com.wows.ships.service;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.GoldShips;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
public interface GoldShipsService extends IService<GoldShips> {

    ShipVoOrder getGoldShipInfo(String shipId);
}
