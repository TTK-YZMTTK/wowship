package com.wows.ships.controller;


import com.wows.commonutils.Ret;
import com.wows.ships.entity.AllShips;
import com.wows.ships.entity.GoldShips;
import com.wows.ships.service.AllShipsService;
import com.wows.ships.service.GoldShipsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
@RestController
@RequestMapping("/wowsservice/goldships")
public class GoldShipsController {


    @Autowired
    private GoldShipsService goldShipsService;

    @Autowired
    private AllShipsService shipsService;

    //添加金币船
    @PostMapping("addGoldShip")
    @ApiOperation(value = "添加金币船")
    public Ret addGoldShip(@RequestBody GoldShips ship) {
        String id = ship.getId();
        String name = ship.getName();
        goldShipsService.save(ship);
        AllShips allShip = new AllShips();
        allShip.setId(id);
        allShip.setName(name);
        allShip.setType(1);
        shipsService.save(allShip);
        return Ret.ok();
    }
}

