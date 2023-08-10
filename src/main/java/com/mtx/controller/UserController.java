package com.mtx.controller;


import com.mtx.common.ResponseResult;
import com.mtx.entity.User;
import com.mtx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author mtx
 * @since 2023-08-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        //登录
        return userService.login(user);
    }

    @RequestMapping("/list")
    @PreAuthorize("hasAnyAuthority('admin:dept:list')")
    public String list(){
        return "list";
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }


}
