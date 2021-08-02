package com.wows.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wows.commentbase.exceptionhandler.MyException;
import com.wows.commonutils.Ret;
import com.wows.order.client.UserClient;
import com.wows.order.controller.ShipOrderController;
import com.wows.order.entity.PayLog;
import com.wows.order.entity.ShipOrder;
import com.wows.order.mapper.PayLogMapper;
import com.wows.order.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wows.order.service.ShipOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-05-21
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

    @Autowired
    private ShipOrderService shipOrder;

    @Autowired
    private UserClient userClient;

    @Override
    public Boolean addPayLog(String orderNo) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("order_no",orderNo);
        ShipOrder orderOne = shipOrder.getOne(wrapper);
        if (orderOne.getStatus().intValue() == 1){
            return true;
        }
        //先支付后update支付状态
        Integer type = orderOne.getType();
        Integer price = orderOne.getPrice();
        //用微服务调用，调用user模块的付费方法实现付费，成功之后插入支付记录
        Ret ret = userClient.payFor(orderOne.getUserId(), type, price);
        //支付结束，根据返回的结果进行判定
        if (ret.getCode().intValue() == 20000){
            orderOne.setStatus(1);
            shipOrder.updateById(orderOne);
            PayLog payLog = new PayLog();
            payLog.setOrderNo(orderNo);
            payLog.setPayTime(new Date());
            payLog.setTotalFee(orderOne.getPrice());
            payLog.setTransactionId("114514");//这个可以自己生成，这里偷个懒，毕竟没有使用正规的支付方式，没有流水号
            payLog.setTradeState(1);
            payLog.setPayType(type);
            baseMapper.insert(payLog);
        }else {
            throw new MyException(20001,"支付失败");
        }
        return true;
    }
}
