package com.wows.order.client;


import com.wows.commonutils.ordervo.ShipVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("service-ships")
public interface ShipClient {


    //根据船只id查询船只
    @GetMapping("wowsservice/allships/findShipInfoById/{shipId}")
    public ShipVoOrder findShipInfoById(@PathVariable("shipId") String shipId);


}
