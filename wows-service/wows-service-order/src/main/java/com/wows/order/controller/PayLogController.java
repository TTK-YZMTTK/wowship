package com.wows.order.controller;


import com.wows.commonutils.Ret;
import com.wows.order.service.PayLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.ReactiveTransaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-05-21
 */
@RestController
@RequestMapping("/wowsservice/paylog")
public class PayLogController {

    @Autowired
    private PayLogService payLogService;

    //生成支付记录,由于咱们这没有用微信支付，所以内部操作一下，利用usemessage表里的version字段来控制。
    @PostMapping("creatLog/{orderNo}")
    @ApiOperation("根据订单号生成支付记录")
    public Ret creatPaylog(@PathVariable String orderNo) {
        Boolean end = payLogService.addPayLog(orderNo);
        if (end) {
            return Ret.ok().message("支付成功");
        }else {
            return Ret.error().message("支付失败");
        }

    }
}

