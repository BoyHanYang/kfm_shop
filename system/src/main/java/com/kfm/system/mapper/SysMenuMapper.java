package com.kfm.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.system.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author AdminHan
* @description 针对表【sys_menu】的数据库操作Mapper
* @createDate 2023-12-19 22:31:02
* @Entity com.kfm.system.model.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectMenusWithRoleIds(List<Integer> ids);
}




