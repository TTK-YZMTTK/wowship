package com.wows.ships.controller;


import com.wows.commonutils.Ret;
import com.wows.commonutils.ordervo.ShipVoOrder;
import com.wows.ships.service.AllShipsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/wowsservice/allships")
public class AllShipsController {

    @Autowired
    private AllShipsService allShipsService;

    //根据船只id查询船只所有信息（涉及多表查询）
    @GetMapping("findShipInfoById/{shipId}")
    @ApiOperation(value = "根据id查询船只")
    public ShipVoOrder findShipInfoById(@PathVariable String shipId){
        ShipVoOrder ship = allShipsService.getShipInfoById(shipId);
        return ship;
    }
}

