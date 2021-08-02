package com.wows.order.client;


import com.wows.commonutils.Ret;
import com.wows.commonutils.ordervo.UcenterMemberVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("service-user")
public interface UserClient {

    //根据用户id获取用户信息
    @GetMapping("wowsservice/user/findUserById/{userid}")
    public UcenterMemberVoOrder findUserById(@PathVariable("userid") String userid);

    //付费功能
    @PostMapping("wowsservice/message/payFor")
    public Ret payFor(@RequestParam("userId") String userId, @RequestParam("type") Integer type, @RequestParam("price") Integer price);
}
