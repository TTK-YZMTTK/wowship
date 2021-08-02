package com.wows.ships.mapper;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.GoldShips;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
public interface GoldShipsMapper extends BaseMapper<GoldShips> {

    ShipVoOrder getGoldShipInfo(String shipId);
}
