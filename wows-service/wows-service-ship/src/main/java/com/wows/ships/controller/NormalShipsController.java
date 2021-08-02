package com.wows.ships.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wows.commonutils.Ret;
import com.wows.ships.entity.AllShips;
import com.wows.ships.entity.NormalShips;
import com.wows.ships.entity.vo.ShipVo;
import com.wows.ships.service.AllShipsService;
import com.wows.ships.service.NormalShipsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-03-29
 */
@RestController
@RequestMapping("/wowsservice/normalships")
public class NormalShipsController {

    @Autowired
    private NormalShipsService normalShipsService;

    @Autowired
    private AllShipsService shipsService;

    //根据船名寻找船只
    @GetMapping("findByName/{name}")
    @ApiOperation(value = "根据船名寻找船只")
    public Ret findByName(@PathVariable String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", name);
        NormalShips one = normalShipsService.getOne(wrapper);
        return Ret.ok().data("ship", one);
    }

    //根据船名模糊查询
    @GetMapping("findNameShips/{name}")
    @ApiOperation(value = "根据船名模糊查询")
    public Ret findNameShips(@PathVariable String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name", name);
        List list = normalShipsService.list(wrapper);
        return Ret.ok().data("ships", list);

    }

    //（根据船名）多表查询
    @GetMapping("getShipInfo/{name}")
    @ApiOperation(value = "根据船名多表查询")
    public Ret getShipInfo(@PathVariable String name) {
        ShipVo shipVo = normalShipsService.getShipInfo(name);
        return Ret.ok().data("shipvo", shipVo);
    }


    //添加船只
    @PostMapping("addship")
    @ApiOperation(value = "添加船只")
    public Ret addship(@RequestBody NormalShips ship) {
        String id = ship.getId();
        String name = ship.getName();
        normalShipsService.save(ship);
        AllShips allShip = new AllShips();
        allShip.setId(id);
        allShip.setName(name);
        allShip.setType(0);
        shipsService.save(allShip);
        return Ret.ok();
    }

    //根据末端船只名字，查询全线船只
    @GetMapping("findAll/{name}")
    @ApiOperation(value = "根据末端查全线")
    public Ret findAll(@PathVariable String name) {
        ArrayList<NormalShips> allShip = new ArrayList();
        ArrayList<NormalShips> all = normalShipsService.findAll(name, allShip);
        return Ret.ok().data("allShip", all);
    }

    //用于测试BUG的方法
    @GetMapping("testA/{name}")
    @ApiOperation(value = "测试")
    public Ret testA(@PathVariable String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", name);
        NormalShips one = normalShipsService.getOne(wrapper);
        return Ret.ok().data("ship", one);

    }
}
