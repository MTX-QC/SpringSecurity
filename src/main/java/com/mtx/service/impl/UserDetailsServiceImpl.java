package com.mtx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mtx.entity.LoginUser;
import com.mtx.entity.User;
import com.mtx.mapper.SysMenuMapper;
import com.mtx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //如果没有查询到用户就抛出异常
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中
//        List<String> list = new ArrayList<>(Arrays.asList("test"));
        List<String> list = sysMenuMapper.selectPermsByUserId(user.getId());
        //把数据封装成UserDetail返回
        return new LoginUser(user,list);
    }
}
