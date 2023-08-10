package com.mtx.service;

import com.mtx.common.ResponseResult;
import com.mtx.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author mtx
 * @since 2023-08-05
 */
public interface IUserService extends IService<User> {

    ResponseResult login(User user);

    ResponseResult logout();
}
