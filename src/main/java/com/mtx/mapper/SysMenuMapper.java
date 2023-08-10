package com.mtx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mtx.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author mtx
 * @since 2023-08-10
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<String> selectPermsByUserId(Long userid);
}
