package com.wows.ships.service.impl;

import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.AllShips;
import com.wows.ships.mapper.AllShipsMapper;
import com.wows.ships.service.AllShipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wows.ships.service.GoldShipsService;
import com.wows.ships.service.NormalShipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-03-31
 */
@Service
public class AllShipsServiceImpl extends ServiceImpl<AllShipsMapper, AllShips> implements AllShipsService {

    @Autowired
    private NormalShipsService normalShips;

    @Autowired
    private GoldShipsService goldShips;


    //根据船只id查询船只所有信息（去各个表的mapper下写sql）
    @Override
    public ShipVoOrder getShipInfoById(String shipId) {
        AllShips ships = baseMapper.selectById(shipId);
        Integer type = ships.getType();
       while (true){
           if (type == 0){
               //意味着这是银币船，故去normal表寻找
               ShipVoOrder ship = normalShips.getNormalShipInfo(shipId);
               return ship;
           }
           if (type == 1){
               //意味着这是金币船，故去gold表寻找
               ShipVoOrder ship = goldShips.getGoldShipInfo(shipId);
               return ship;
           }
        //其他类型船只同理，不做赘叙。
       }
    }

}
