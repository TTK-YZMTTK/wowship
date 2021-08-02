package com.wows.user.service.impl;

import com.wows.commonutils.Ret;
import com.wows.user.entity.Message;
import com.wows.user.mapper.MessageMapper;
import com.wows.user.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-04-06
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    //付费功能
    @Override
    public Ret payInfo(String userId,Integer type,Integer price) {
        Message message = baseMapper.selectById(userId);

        if (type.intValue() == 0){
            Integer silver = message.getSilver() - price;
            if (silver.intValue() >= 0){
                message.setSilver(silver);
                baseMapper.updateById(message);
                return Ret.ok().code(20000).message("支付成功");
            }else {
                return Ret.error().code(20001).message("该物资不足，支付失败");
            }
        }
        if (type.intValue() == 1) {
            Integer gold = message.getGold() - price;
            if (gold.intValue() >= 0) {
                message.setGold(gold);
                baseMapper.updateById(message);
                return Ret.ok().code(20000).message("支付成功");
            } else {
                return Ret.error().code(20001).message("该物资不足，支付失败");
            }
        }
        if (type.intValue() == 2){
            Integer general  = message.getGeneral() - price;
            if (general.intValue() >= 0){
                message.setGeneral(general);
                baseMapper.updateById(message);
                return Ret.ok().code(20000).message("支付成功");
            }else {
                return Ret.error().code(20001).message("该物资不足，支付失败");
            }
        }
        //其余支付方式类同，不再重复，只拿3个举例子。
        return Ret.ok().code(20000);
        }
    }

