package com.wows.ships.mapper;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.NormalShips;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wows.ships.entity.vo.ShipVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author OldFish
 * @since 2021-03-29
 */
public interface NormalShipsMapper extends BaseMapper<NormalShips> {

    ShipVo getShipInfo(String name);

    ShipVoOrder getNormalShipInfo(String shipId);
}
