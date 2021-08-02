package com.wows.order.service;

import com.wows.order.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-05-21
 */
public interface PayLogService extends IService<PayLog> {

    //生成支付记录
    Boolean addPayLog(String orderNo);
}
