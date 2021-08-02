package com.wows.user.controller;


import com.wows.commonutils.Ret;
import com.wows.user.entity.Message;
import com.wows.user.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
@RestController
@RequestMapping("/wowsservice/message")
public class MessageController {

    @Autowired
    private MessageService messageService;


    //根据用户id查询用户资源
    @GetMapping("checkResources/{userId}")
    public Ret checkResources(@PathVariable String userId){
        Message userMessage = messageService.getById(userId);
        return Ret.ok().data("message",userMessage);
    }

    //付费功能
    @PostMapping("payFor")
    public Ret payFor(@RequestParam("userId") String userId,@RequestParam("type") Integer type,@RequestParam("price") Integer price){
        Ret ret = messageService.payInfo(userId,type,price);
        return ret;
    }

}

