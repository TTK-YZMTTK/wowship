package com.wows.ships.service.impl;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.GoldShips;
import com.wows.ships.mapper.GoldShipsMapper;
import com.wows.ships.service.GoldShipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
@Service
public class GoldShipsServiceImpl extends ServiceImpl<GoldShipsMapper, GoldShips> implements GoldShipsService {

    //根据id查询船只信息
    @Override
    public ShipVoOrder getGoldShipInfo(String shipId) {
        return baseMapper.getGoldShipInfo(shipId);
    }
}
