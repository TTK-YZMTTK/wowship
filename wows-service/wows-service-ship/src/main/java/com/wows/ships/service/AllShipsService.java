package com.wows.ships.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.AllShips;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-03-31
 */
public interface AllShipsService extends IService<AllShips> {

    //根据船只id查询船只所有信息（涉及多表查询）
    ShipVoOrder getShipInfoById(String shipId);
}
