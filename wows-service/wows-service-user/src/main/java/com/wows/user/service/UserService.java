package com.wows.user.service;

import com.wows.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wows.user.entity.vo.RegisterVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author OldFish
 * @since 2021-03-03
 */
public interface UserService extends IService<User> {

    //普通注册的方法
     void registerUser(RegisterVo registerVo);

}
