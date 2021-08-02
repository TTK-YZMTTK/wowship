package com.wows.ships.service;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.NormalShips;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wows.ships.entity.vo.ShipVo;

import java.util.ArrayList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-03-29
 */
public interface NormalShipsService extends IService<NormalShips> {

    //（根据船名）多表查询
    ShipVo getShipInfo(String name);

    //根据末端船只名字，查询全线船只
    ArrayList<NormalShips> findAll(String name, ArrayList<NormalShips> all);

    //根据船只id进行查询
    ShipVoOrder getNormalShipInfo(String shipId);
}
