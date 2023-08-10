package com.mtx.mapper;

import com.mtx.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author mtx
 * @since 2023-08-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
