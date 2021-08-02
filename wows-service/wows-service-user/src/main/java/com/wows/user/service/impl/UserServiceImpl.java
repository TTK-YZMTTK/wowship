package com.wows.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wows.commentbase.exceptionhandler.MyException;
import com.wows.commonutils.GetNumberUID;
import com.wows.commonutils.MD5;
import com.wows.user.entity.Message;
import com.wows.user.entity.User;
import com.wows.user.entity.vo.RegisterVo;
import com.wows.user.mapper.UserMapper;
import com.wows.user.service.MessageService;
import com.wows.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author OldFish
 * @since 2021-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MessageService messageService;



    //普通注册
    @Override
    public void registerUser(RegisterVo registerVo) {
        String email = registerVo.getEmail();//获取注册用户填写的邮箱地址
        String nickname = registerVo.getNickname();//获取注册用户填写的昵称
        Boolean sex = registerVo.getSex();//获取注册用户填写的性别
        String mobile = registerVo.getMobile();//获取注册用户填写的电话号码
        String password = registerVo.getPassword();//获取注册用户填写的密码

        //判断信息是否为空
        if (StringUtils.isEmpty(nickname)|| StringUtils.isEmpty(password)){
                throw new MyException(20001,"存在关键信息为空");
        }

        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("nickname",nickname);
        User user = baseMapper.selectOne(wrapper);

        //判断昵称是否冲突
        if (null != user){
            throw new MyException(20001,"该昵称已经存在");
        }
        //判断密码是否大于6位
        if (password.length() <= 6 && password.length() >= 20){
            throw new MyException(20001,"密码长度应在6、20位或之间，请从新设置密码");
        }

        //若都符合，则注册用户，加入数据库
        User newUser = new User();
        newUser.setNickname(nickname);
        newUser.setEmail(email);
        newUser.setMobile(mobile);
        newUser.setPassword(MD5.encrypt(password));//密码用MD5方式加密
        newUser.setSex(sex);
        newUser.setUid(GetNumberUID.getId());
        baseMapper.insert(newUser);

        //添加成功之后，为用户初始化物资
        Message message = new Message();
        message.setId(newUser.getUid());
        message.setSilver(50000);
        messageService.save(message);
    }


}
