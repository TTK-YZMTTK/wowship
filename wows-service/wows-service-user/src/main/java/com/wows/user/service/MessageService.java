package com.wows.user.service;

import com.wows.commonutils.Ret;
import com.wows.user.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
public interface MessageService extends IService<Message> {

    //付费功能
    Ret payInfo(String userId,Integer type,Integer price);
}
