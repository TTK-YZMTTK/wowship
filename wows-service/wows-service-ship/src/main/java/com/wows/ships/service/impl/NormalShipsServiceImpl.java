package com.wows.ships.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.entity.NormalShips;
import com.wows.ships.entity.vo.ShipVo;
import com.wows.ships.mapper.NormalShipsMapper;
import com.wows.ships.service.NormalShipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-03-29
 */
@Service
public class NormalShipsServiceImpl extends ServiceImpl<NormalShipsMapper, NormalShips> implements NormalShipsService {

    //（根据船名）多表查询
    @Override
    public ShipVo getShipInfo(String name) {
        return baseMapper.getShipInfo(name);
    }

  //根据末端船只名字，查询全线船只,递归调用方法。
    @Override
    public ArrayList<NormalShips> findAll(String name, ArrayList<NormalShips> all) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("name",name);
            NormalShips normalShips = baseMapper.selectOne(wrapper);
            all.add(normalShips);
            QueryWrapper testWrapper = new QueryWrapper();
            testWrapper.eq("id",normalShips.getParentId());
            if (baseMapper.selectCount(testWrapper) > 0 ){
                System.out.println(normalShips.getParentId() != null);
                NormalShips nextShip = baseMapper.selectById(normalShips.getParentId());
                String nextName = nextShip.getName();
                findAll(nextName,all);
            }
            return all;
    }

    @Override
    public ShipVoOrder getNormalShipInfo(String shipId) {
        return baseMapper.getNormalShipInfo(shipId);
    }


}
