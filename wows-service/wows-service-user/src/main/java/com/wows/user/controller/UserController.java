package com.wows.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wows.commonutils.Ret;
import com.wows.commonutils.ordervo.UcenterMemberVoOrder;
import com.wows.user.entity.User;
import com.wows.user.entity.vo.CreatePageVo;
import com.wows.user.entity.vo.NickpageVo;
import com.wows.user.entity.vo.RegisterVo;
import com.wows.user.service.MessageService;
import com.wows.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author OldFish
 * @since 2021-03-03
 */
@RestController
@RequestMapping("/wowsservice/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    //普通注册的方法
    @PostMapping("register")
    @ApiOperation(value = "普通注册")
    public Ret registUser(@RequestBody RegisterVo registerVo) {
        userService.registerUser(registerVo);
        return Ret.ok();
    }

    //分页查询
    @PostMapping("pageFind/{current}/{limit}")
    @ApiOperation(value = "分页模糊查询")
    public Ret pageFind(@PathVariable long current, @PathVariable long limit,
                        @RequestBody(required = false) NickpageVo nickpageVo) {
        String nick = nickpageVo.getNickname();
        Page<User> page = new Page(current, limit);
        QueryWrapper<User> wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(nick)) {
            wrapper.like("nickname", nick);
        }
        userService.page(page, wrapper);
        List<User> records = page.getRecords();
        long total = page.getTotal();
        return Ret.ok().data("total", total).data("map", records);
    }

    //(条件分页查询)根据注册时间段查询，并排序
    @PostMapping("pageFindByDate/{current}/{limit}")
    @ApiOperation(value = "根据注册时间排序")
    public Ret pageFindByDate(@PathVariable long current, @PathVariable long limit,
                              @RequestBody(required = false) CreatePageVo createPageVo) {
        String begin = createPageVo.getBegin();
        String end = createPageVo.getEnd();
        Page<User> page = new Page(current, limit);
        QueryWrapper<User> wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }
        wrapper.orderByDesc("gmt_create");
        userService.page(page, wrapper);
        List<User> records = page.getRecords();
        long total = page.getTotal();
        return Ret.ok().data("total", total).data("map", records);
    }

    //根据昵称查询用户
    @GetMapping("findUserByNick/{nickname}")
    @ApiOperation(value = "根据昵称查找用户")
    public Ret findUser(@PathVariable String nickname) {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("nickname", nickname);
        User one = userService.getOne(wrapper);
        return Ret.ok().data("user", one);
    }

    //根据昵称修改用户
    @PostMapping("updateUserByNick/{nickname}")
    @ApiOperation(value = "根据昵称修改用户数据")
    public Ret updateUserByNick(@PathVariable String nickname, @RequestBody User user) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("nickname", nickname);
        boolean update = userService.update(user, wrapper);
        if (update) {
            return Ret.ok();
        }
        return Ret.error();
    }

    //根据UID查找用户信息
    @GetMapping("findUserById/{userid}")
    @ApiOperation(value = "根据id查找用户数据")
    public UcenterMemberVoOrder findUserById(@PathVariable String userid) {
        User userById = userService.getById(userid);
        UcenterMemberVoOrder ucenterMemberVoOrder = new UcenterMemberVoOrder();
        BeanUtils.copyProperties(userById,ucenterMemberVoOrder);
        return ucenterMemberVoOrder;
    }

    //根据id更改用户信息
    @PostMapping("updateUserById")
    @ApiOperation(value = "根据id修改用户数据")
    public Ret updateUserById(@RequestBody User user) {
        boolean b = userService.updateById(user);
        if (b) {
            return Ret.ok();
        }
        return Ret.error();
    }

    //逻辑删除（封号惩罚）
    @DeleteMapping("{id}")
    @ApiOperation(value = "逻辑删除的方法")
    public Ret removeUser(@PathVariable String id) {
        boolean flag = userService.removeById(id);
        if (flag) {
            return Ret.ok();
        } else {
            return Ret.error();
        }
    }
}


